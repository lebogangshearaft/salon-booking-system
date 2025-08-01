package com.salonbooking.repository;

import com.salonbooking.model.Appointment;
import com.salonbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByClient(User client);
    List<Appointment> findByStaff(User staff);
}
