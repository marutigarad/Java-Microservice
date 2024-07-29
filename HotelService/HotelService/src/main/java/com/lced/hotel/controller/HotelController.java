package com.lced.hotel.controller;

import com.lced.hotel.enities.Hotel;
import com.lced.hotel.services.HotelIMPLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelIMPLService hotelIMPLService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel1= hotelIMPLService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotelList = hotelIMPLService.getAllHotels();
        return ResponseEntity.ok().body(hotelList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> gethotelById(@PathVariable String id){
        Hotel hotel = hotelIMPLService.getHotelById(id);
        return ResponseEntity.ok().body(hotel);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> deletByIdHotels(@PathVariable String id){
        Hotel hotel = hotelIMPLService.deleteHotel(id);
        return ResponseEntity.ok().body(hotel);
    }

}
