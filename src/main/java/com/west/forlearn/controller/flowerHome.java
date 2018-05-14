package com.west.forlearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class flowerHome {

    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String getFlower(){
        return "welcome to my yard.";
    }
}
