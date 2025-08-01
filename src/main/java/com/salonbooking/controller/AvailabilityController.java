package com.salonbooking.controller;

import com.salonbooking.model.StaffAvailability;
import com.salonbooking.model.User;
import com.salonbooking.service.StaffAvailabilityService;
import com.salonbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/staff/availability")
public class AvailabilityController {

    @Autowired
    private StaffAvailabilityService availabilityService;

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public List<StaffAvailability> getMyAvailability(Principal principal) {
        User staff = userService.findByEmail(principal.getName()).orElseThrow();
        return availabilityService.getByStaff(staff);
    }

    @PostMapping
    public StaffAvailability addAvailability(@RequestBody StaffAvailability availability) {
        return availabilityService.save(availability);
    }
}
