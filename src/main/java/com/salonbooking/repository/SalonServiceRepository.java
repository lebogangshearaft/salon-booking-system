package com.salonbooking.repository;

import com.salonbooking.model.SalonService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonServiceRepository extends JpaRepository<SalonService, Long> {
}
