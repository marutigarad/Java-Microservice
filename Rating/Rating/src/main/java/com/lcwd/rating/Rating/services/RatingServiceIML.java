package com.lcwd.rating.Rating.services;

import com.lcwd.rating.Rating.enities.Rating;
import com.lcwd.rating.Rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceIML implements RatingService {


    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

//    @Override
//    public Rating getByIdRating(String id) {
//        return ratingRepository.findBy(id);
//    }

    @Override
    public List<Rating> getByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public void deleteByIdRating(String id) {
            ratingRepository.deleteById(id);
    }
}
