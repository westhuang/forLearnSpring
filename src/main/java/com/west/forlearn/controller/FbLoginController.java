package com.west.forlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

// 登陆接口
@RestController
public class FbLoginController {

    private static Logger logger=LoggerFactory.getLogger(FbLoginController.class);

    // 登陆处理
    @RequestMapping(value="/fg_login", method=RequestMethod.POST)
    public RespEntity login(HttpServletRequest httpRequest, HttpServletResponse response) throws Exception{

        // 获取入参
        logger.info("post:" + httpRequest.getParameter("name")+"-"+httpRequest.getParameter("desc")+"-"+httpRequest.getParameter("ttt"));

        // 调微信完成登陆

        // 调service写/更新用户信息表

        // 存session
        HttpSession httpSession = httpRequest.getSession();
        httpSession.setAttribute(WebSecurityConfig.SESSION_DATA, httpRequest.getParameter("name")+"-"+httpRequest.getParameter("desc"));
        httpSession.setMaxInactiveInterval(1200);

        // 返回
        return new RespEntity(0, ("login success:" + (new Date().toString())));
    }
}
