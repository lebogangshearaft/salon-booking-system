package com.salonbooking.controller;

import com.salonbooking.model.User;
import com.salonbooking.security.JwtUtil;
import com.salonbooking.service.UserService;
import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User newUser = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userService.saveUser(newUser);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()
                    )
            );

            User user = userService.findByEmail(request.getEmail()).orElseThrow();
            String token = jwtUtil.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token, user.getRole().name()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    @Getter @Setter
    public static class RegisterRequest {
        private String name;
        private String email;
        private String password;
        private User.Role role;
    }

    @Getter @Setter
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @Getter @Setter @AllArgsConstructor
    public static class LoginResponse {
        private String token;
        private String role;
    }
}
