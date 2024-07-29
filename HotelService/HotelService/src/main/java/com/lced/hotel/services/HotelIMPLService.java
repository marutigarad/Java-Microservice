package com.lced.hotel.services;

import com.lced.hotel.enities.Hotel;
import com.lced.hotel.exception.ResourceNotFoundException;
import com.lced.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelIMPLService implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel not found for given id"+id));
    }

    @Override
    public Hotel deleteHotel(String id) {
        Hotel hotel= hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel not found for given id"+id));
         hotelRepository.deleteById(id);
        return hotel;
    }
}
