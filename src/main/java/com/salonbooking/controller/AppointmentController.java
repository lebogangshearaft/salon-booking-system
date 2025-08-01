package com.salonbooking.controller;

import com.salonbooking.model.Appointment;
import com.salonbooking.model.User;
import com.salonbooking.service.AppointmentService;
import com.salonbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public List<Appointment> getMyAppointments(Principal principal) {
        User client = userService.findByEmail(principal.getName()).orElseThrow();
        return appointmentService.getAppointmentsByClient(client);
    }

    @PostMapping
    public Appointment book(@RequestBody Appointment appointment) {
        return appointmentService.book(appointment);
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id) {
        appointmentService.cancel(id);
    }
}
