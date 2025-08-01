package com.salonbooking.controller;

import com.salonbooking.model.SalonService;
import com.salonbooking.service.SalonServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private SalonServiceService serviceService;

    @GetMapping
    public List<SalonService> getAll() {
        return serviceService.getAll();
    }

    @PostMapping
    public SalonService create(@RequestBody SalonService service) {
        return serviceService.save(service);
    }
}
