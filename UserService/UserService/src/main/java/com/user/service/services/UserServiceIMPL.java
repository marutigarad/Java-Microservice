package com.user.service.services;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceIMPL.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User  user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found ...."+userId));
        //Here we call Rating service using the RESTTemplate
        Rating [] ratingsList =restTemplate.getForObject("http://RATING/ratings/user/"+userId, Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingsList).toList();

        logger.info("{}",ratings);
         List<Rating> ratingList =ratings.stream().map(rating -> {
               rating.getHotelId();
               ResponseEntity<Hotel> hotels = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class );
               Hotel hotel= hotels.getBody();
               logger.info("this is the respone for "+rating.getHotelId() +" "+hotels.getStatusCode() , hotels.getStatusCode());
               rating.setHotel(hotel);
                return  rating;
         }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return  user;
    }
    @Override
    public User deleteUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found ...."+userId));
        userRepository.delete(user);
        return user;
    }
}
