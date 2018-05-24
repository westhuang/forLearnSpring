package com.west.forlearn.controller;

import com.west.forlearn.comm.HttpsCall;
import com.west.forlearn.comm.RespEntity;
import com.west.forlearn.service.SetUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 登陆接口
@RestController
public class FbLoginController {

    private static Logger logger = LoggerFactory.getLogger(FbLoginController.class);

    // 主入口
    @RequestMapping(value="/fg/fg_login", method=RequestMethod.POST)
    public RespEntity excute(HttpServletRequest httpRequest, HttpServletResponse response) throws Exception{

        // 获取入参
        HashMap<String, String> mapParams = new HashMap<String, String>();
        mapParams.put("code", httpRequest.getParameter("code"));
        mapParams.put("nickName", httpRequest.getParameter("nickName"));
        mapParams.put("avatarUrl", httpRequest.getParameter("avatarUrl"));
        mapParams.put("gender", httpRequest.getParameter("gender"));
        mapParams.put("city", httpRequest.getParameter("city"));
        mapParams.put("province", httpRequest.getParameter("province"));
        mapParams.put("country", httpRequest.getParameter("country"));

        // 调微信获取微信session_key和openid
        String httpRsp = getWxKey(mapParams.get("code"));
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        Map<String, Object> wxRsp = jsonParser.parseMap(httpRsp);
        if (!wxRsp.containsKey("session_key") || !wxRsp.containsKey("openid")){ // 获取失败
            logger.error("call wx jscode2sesion fail: " + httpRsp);
             return new RespEntity(19000002, "login fail, u can try again");
        }
        else {                                                                  // 获取成功
            mapParams.put("sessionKey", wxRsp.get("session_key").toString());
            mapParams.put("openid", wxRsp.get("openid").toString());
        }

        // 调service写/更新用户信息表
        saveUserInfo(mapParams);

        // 存session
        saveSession(httpRequest, mapParams);

        // 返回
        return new RespEntity(0, ("login success:" + (new Date().toString())));
    }

    // 调微信获取微信session_key和openid
    private String getWxKey(String code){
        return HttpsCall.httpsRequest("https://api.weixin.qq.com/sns/jscode2session", "GET",
                "appid=wxa1fefc7f8231bb36&secret=85e1638081706d984c1e36f9783faf59&grant_type=authorization_code&js_code="+code);
    }

    @Autowired
    private SetUserInfoService userInfoService;

    private void saveUserInfo(HashMap<String, String> mapParams) throws Exception {
        userInfoService.excute(mapParams);
    }

    // 存session
    private void saveSession(HttpServletRequest httpRequest, HashMap<String, String> mapParams){
        HttpSession httpSession = httpRequest.getSession();
        httpSession.setAttribute(WebSecurityConfig.SESSION_DATA, mapParams.toString());
        httpSession.setMaxInactiveInterval(1200);
    }
}
