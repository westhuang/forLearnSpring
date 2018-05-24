package com.west.forlearn.controller;

import com.west.forlearn.comm.RespEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    RespEntity handleException(){
        return new RespEntity(19000000, "unkown err, plz try again later");
    }
}
