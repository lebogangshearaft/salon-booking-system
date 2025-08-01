package com.salonbooking.service;

import com.salonbooking.model.Appointment;
import com.salonbooking.model.User;
import com.salonbooking.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsByClient(User client) {
        return appointmentRepository.findByClient(client);
    }

    public List<Appointment> getAppointmentsByStaff(User staff) {
        return appointmentRepository.findByStaff(staff);
    }

    public Appointment book(Appointment appointment) {
        // TODO: add conflict checking logic
        return appointmentRepository.save(appointment);
    }

    public void cancel(Long id) {
        appointmentRepository.deleteById(id);
    }
}
