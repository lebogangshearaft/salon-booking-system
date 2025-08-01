package com.salonbooking.repository;

import com.salonbooking.model.Rating;
import com.salonbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByStaff(User staff);
}
