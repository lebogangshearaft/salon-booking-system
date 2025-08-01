package com.salonbooking.controller;

import com.salonbooking.model.Rating;
import com.salonbooking.model.User;
import com.salonbooking.service.RatingService;
import com.salonbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Rating leaveRating(@RequestBody Rating rating) {
        return ratingService.save(rating);
    }

    @GetMapping("/staff/{staffId}")
    public List<Rating> getRatings(@PathVariable Long staffId) {
        User staff = userService.findByEmail(
                userService.findByEmail("staff@example.com").orElseThrow().getEmail()).orElseThrow();
        staff.setId(staffId);
        return ratingService.getRatingsForStaff(staff);
    }
}
