package com.lcwd.rating.Rating.controller;


import com.lcwd.rating.Rating.enities.Rating;
import com.lcwd.rating.Rating.services.RatingServiceIML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingController {

    @Autowired
    private RatingServiceIML ratingServiceIML;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServiceIML.saveRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating() {
        return ResponseEntity.ok(ratingServiceIML.getAllRating());
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUser(@PathVariable String userId) {
        return ResponseEntity.ok(ratingServiceIML.getByUserId(userId));
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotel(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingServiceIML.getByHotelId(hotelId));
    }
}
