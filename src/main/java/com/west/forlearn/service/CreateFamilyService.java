package com.west.forlearn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.west.forlearn.comm.Encrypt;
import com.west.forlearn.dao.FamilyInfo;
import com.west.forlearn.dao.UserInfo;
import com.west.forlearn.dao.mapper.FamilyMapper;
import com.west.forlearn.dao.mapper.UserInfoMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 创建家庭博客
@Service
public class CreateFamilyService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CreateFamilyService.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private FamilyMapper familyMapper;

    // 主入口
    @Transactional
    public void excute(final Map<String, String> params) throws Exception {

        // 查询用户信息
        List<UserInfo> userInfoList = queryUserInfo(params.get("create_user"));

        // 创建家庭信息
        long fid = createFamily(params);

        // 更新用户信息
        updateUserInfo(fid, userInfoList.get(0));

        return;
    }

    // 查询用户信息
    private List<UserInfo> queryUserInfo(final String openid) throws Exception {
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfoLock(openid);

        // 检查
        if (!userInfoList.isEmpty() && 1 != userInfoList.size()){
            logger.error("query userinfo return more than 1 data");
            throw new Exception("qry db num err");
        }

        if (!userInfoList.isEmpty() && !userInfoList.get(0).getSign().equals(Encrypt.SHA256(userInfoList.get(0).toString()+"134"))){
            logger.error("query userinfo sign err");
            throw new Exception("qry db sign err");
        }

        return userInfoList;
    }

    // 创建家庭信息
    private long createFamily(final Map<String, String> params) throws JsonProcessingException {
        FamilyInfo familyInfo = new FamilyInfo();
        familyInfo.setName(params.get("family_name"));
        familyInfo.setBackurl(params.get("family_backurl"));
        familyInfo.setCreateUser(params.get("create_user"));
        familyInfo.setUserNum(1);
        familyInfo.setState(1);

        ArrayList<FamilyUser> familyUserList = new ArrayList<FamilyUser>();
        FamilyUser familyUser = new FamilyUser();
        familyUser.setOpenid(params.get("create_user"));
        familyUser.setRemark(params.get("user_remark"));
        familyUser.setJoinTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").toString());
        familyUserList.add(familyUser);
        ObjectMapper objectMapper = new ObjectMapper();
        String strUserList = objectMapper.writeValueAsString(familyUserList);
        familyInfo.setUserList(strUserList);

        familyInfo.setSign(Encrypt.SHA256(familyInfo.toString()+"156"));

        familyMapper.insertFamilyInfo(familyInfo);

        return familyInfo.getFid();
    }

    // 更新用户信息
    private void updateUserInfo(long fid, UserInfo userInfo) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList<UserFamily> userFamilyList = new ArrayList<UserFamily>();logger.info("===>2 "+ fid);
        if (!userInfo.getFamilyList().isEmpty()){
            userFamilyList = objectMapper.readValue(userInfo.getFamilyList(), ArrayList.class);
        }

        UserFamily userFamily = new UserFamily();
        userFamily.setFid(fid);
        userFamily.setState(1);
        userFamilyList.add(userFamily);
        String strFamilyList = objectMapper.writeValueAsString(userFamilyList);
        userInfo.setFamilyList(strFamilyList);

        if (0 == userInfo.getFamilyNum()){ // 已有首页圈子则不更新
            userInfo.setFirstFid(fid);
        }
        userInfo.setFamilyNum(userInfo.getFamilyNum() + 1);
        userInfo.setSign(Encrypt.SHA256(userInfo.toString()+"134"));

        int num = userInfoMapper.updateUserInfo(userInfo);
        if (num >= 2){
            throw new Exception("update date affect more than 1 data");
        }
    }
}
