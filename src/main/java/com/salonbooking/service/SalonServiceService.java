package com.salonbooking.service;

import com.salonbooking.model.SalonService;
import com.salonbooking.repository.SalonServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceService {
    @Autowired
    private SalonServiceRepository salonServiceRepository;

    public List<SalonService> getAll() {
        return salonServiceRepository.findAll();
    }

    public SalonService save(SalonService service) {
        return salonServiceRepository.save(service);
    }
}
