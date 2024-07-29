package com.lced.hotel.services;

import com.lced.hotel.enities.Hotel;

import java.util.List;

public interface HotelService {

    //save hotel in the database
    Hotel saveHotel(Hotel hotel);

    //get all hotel details
    List<Hotel> getAllHotels();

    //get hotels by id
    Hotel getHotelById(String id);

    //delete hotels
    Hotel deleteHotel(String id);


}
