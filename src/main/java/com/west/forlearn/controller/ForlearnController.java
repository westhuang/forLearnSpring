package com.west.forlearn.controller;

import com.west.forlearn.dao.UserEntity;
import com.west.forlearn.service.ForlearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ForlearnController {

    @Autowired
    private ForlearnService userService;

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String getTest(){
        return "welcome!!~~";
    }

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public UserEntity getUser(@RequestParam(value="name") String name){
        return userService.getUser(name);
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public UserEntity setUser(UserEntity user){
        return userService.setUser(user);
    }

}
