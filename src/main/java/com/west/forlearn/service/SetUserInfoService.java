package com.west.forlearn.service;

import com.west.forlearn.comm.Encrypt;
import com.west.forlearn.comm.RespEntity;
import com.west.forlearn.controller.FbLoginController;
import com.west.forlearn.dao.UserInfo;
import com.west.forlearn.dao.mapper.UserInfoMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

// 设置或更新用户信息接口
@Service
public class SetUserInfoService {

    private static org.slf4j.Logger logger=LoggerFactory.getLogger(SetUserInfoService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    // 主入口
    @Transactional
    public void excute(Map<String, String> params) throws Exception {

        // 查询用户信息是否已经存在
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfoLock(params.get("openid"));

        // 检查
        if (!userInfoList.isEmpty() && 1 != userInfoList.size()){
            logger.error("query userinfo return more than 1 data");
            throw new Exception("qry db num err");
        }

        if (!userInfoList.isEmpty() && !userInfoList.get(0).getSign().equals(Encrypt.SHA256(userInfoList.get(0).toString()+"134"))){
            logger.error("query userinfo sign err");
            throw new Exception("qry db sign err");
        }

        // 不存在进行插入
        if (userInfoList.isEmpty()){
            UserInfo userInfo = new UserInfo();
            userInfo.setOpenid(params.get("openid"));
            userInfo.setName(params.get("nickName"));
            userInfo.setAvatarUrl(params.get("avatarUrl"));
            userInfo.setGender(params.get("gender"));
            userInfo.setPosition(params.get("city")+"/"+params.get("province")+"/"+params.get("country"));
            userInfo.setFamilyNum(0);
            userInfo.setFamilyList("");
            userInfo.setFirstFid(0l);
            userInfo.setState(1);
            userInfo.setSign(Encrypt.SHA256(userInfo.toString()+"134"));
            userInfoMapper.insertUserInfo(userInfo);
        }
        // 存在进行更新
        else{
            userInfoList.get(0).setName(params.get("nickName"));
            userInfoList.get(0).setAvatarUrl(params.get("avatarUrl"));
            userInfoList.get(0).setGender(params.get("gender"));
            userInfoList.get(0).setPosition(params.get("city")+"/"+params.get("province")+"/"+params.get("country"));
            userInfoList.get(0).setSign(Encrypt.SHA256(userInfoList.get(0).toString()+"134"));
            int num = userInfoMapper.updateUserInfo(userInfoList.get(0));
            if (num >= 2){
                throw new Exception("update date affect more than 1 data");
            }
        }

        // 返回
        return;
    }
}
