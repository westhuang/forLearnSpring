package com.west.forlearn.controller;

import com.west.forlearn.comm.RespEntity;
import com.west.forlearn.comm.Tools;
import com.west.forlearn.service.CreateFamilyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

// 创建家庭博客接口
@RestController
public class FbCreateFamilyController {

    private static Logger logger = LoggerFactory.getLogger(FbCreateFamilyController.class);

    // 主入口
    @RequestMapping(value="/fb/fb_create_family", method=RequestMethod.POST)
    public RespEntity excute(HttpServletRequest httpRequest, HttpServletResponse response) throws Exception {

        // 获取入参
        HashMap<String, String> mapParams = new HashMap<>();
        mapParams.put("family_name", httpRequest.getParameter("family_name"));
        mapParams.put("family_backurl", httpRequest.getParameter("family_backurl"));

        // 调service
        HttpSession session = httpRequest.getSession();
        String sessionStr = session.getAttribute(WebSecurityConfig.SESSION_DATA).toString();
        Map sessionMap = Tools.StringToMap(sessionStr);
        mapParams.put("create_user", sessionMap.get("openid").toString());
        mapParams.put("user_remark", sessionMap.get("nickName").toString());
        callCreateFamily(mapParams);

        // 返回
        return new RespEntity(0, "ok");
    }

    @Autowired
    private CreateFamilyService createFamilyService;

    private void callCreateFamily(final HashMap<String, String> mapParams) throws Exception {
        createFamilyService.excute(mapParams);
    }
}
