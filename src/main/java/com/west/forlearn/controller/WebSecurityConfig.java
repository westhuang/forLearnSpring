package com.west.forlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
    /**
     * 登录session key
     */
    public final static String SESSION_DATA = "fblogData";
    private static Logger logger=LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor((HandlerInterceptor) getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/fg_login");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();

            // 已经登录
            if (session.getAttribute(SESSION_DATA) != null){
                logger.info("logined:" + session.getAttribute(SESSION_DATA));
                return true;
            }
            else {
                logger.info("need login");
                response.getOutputStream().write("{\"code\":19000001, \"msg\":\"need login\"}".getBytes()); // 返回重新登录错误码
                return false;
            }
        }
    }
}
