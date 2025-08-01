package com.salonbooking.service;

import com.salonbooking.model.Rating;
import com.salonbooking.model.User;
import com.salonbooking.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getRatingsForStaff(User staff) {
        return ratingRepository.findByStaff(staff);
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }
}
