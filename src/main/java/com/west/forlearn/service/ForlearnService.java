package com.west.forlearn.service;

import com.west.forlearn.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForlearnService {

    @Autowired
    private ForlearnRepository userRepository;

    public UserEntity getUser(String name){
        return userRepository.findUserByName(name);
    }

    public UserEntity setUser(UserEntity user){
        return userRepository.save(user);
    }
}
