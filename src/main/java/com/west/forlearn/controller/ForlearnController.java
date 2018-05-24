package com.west.forlearn.controller;

//import org.springframework.context.annotation.Scope;
import com.west.forlearn.dao.UserEntity;
import com.west.forlearn.service.ForlearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@RestController
public class ForlearnController {

    @Autowired
    private ForlearnService userService;

    @RequestMapping(value="/fg/user", method=RequestMethod.GET)
    public UserEntity getUser(@RequestParam(value="name") String name){
        return userService.getUser(name);
    }

    @RequestMapping(value="/fg/user", method=RequestMethod.POST)
    public UserEntity setUser(UserEntity user){
        return userService.setUser(user);
    }

    @RequestMapping(value="/fg/test", method=RequestMethod.GET)
    public String getTest(HttpServletRequest httpRequest){

        Cookie[] cookies = httpRequest.getCookies();
        System.out.println((cookies[0].getName() + ":" + cookies[0].getValue()));

        return "welcome!!~~" + (new Date().toString());
    }
}
