package com.salonbooking.service;

import com.salonbooking.model.StaffAvailability;
import com.salonbooking.model.User;
import com.salonbooking.repository.StaffAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffAvailabilityService {
    @Autowired
    private StaffAvailabilityRepository availabilityRepository;

    public List<StaffAvailability> getByStaff(User staff) {
        return availabilityRepository.findByStaff(staff);
    }

    public StaffAvailability save(StaffAvailability availability) {
        return availabilityRepository.save(availability);
    }
}
