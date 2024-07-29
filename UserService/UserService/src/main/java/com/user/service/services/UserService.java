package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    //create user
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    User deleteUser(String userId);
}
