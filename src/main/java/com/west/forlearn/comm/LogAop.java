package com.west.forlearn.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {

    private static Logger logger=LoggerFactory.getLogger(LogAop.class);

    @Before("execution(* com.west.forlearn.service..*(..))")
    public void logProcess(){
        System.out.println("======>for test");
        logger.info("=====>test info");
        logger.debug("=====>test debug");
    }
}
