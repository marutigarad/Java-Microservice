package com.lcwd.rating.Rating.services;

import com.lcwd.rating.Rating.enities.Rating;

import java.util.List;
import java.util.SimpleTimeZone;

public interface RatingService {

    //save ratings
    Rating saveRating(Rating rating);


    // get all ratings

    List<Rating> getAllRating();


//    //get rating by ids
//    Rating getByIdRating(String id);

    //get rating list by user id
    List<Rating> getByUserId(String userId);


    //get rating by hotel id
    List<Rating> getByHotelId(String hotelId);

    //delete rating by id
    void  deleteByIdRating(String id);

}
