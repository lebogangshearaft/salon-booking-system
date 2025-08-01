package com.salonbooking.repository;

import com.salonbooking.model.StaffAvailability;
import com.salonbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffAvailabilityRepository extends JpaRepository<StaffAvailability, Long> {
    List<StaffAvailability> findByStaff(User staff);
}
