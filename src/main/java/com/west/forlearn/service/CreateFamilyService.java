package com.west.forlearn.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

// 创建家庭博客
@Service
public class CreateFamilyService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CreateFamilyService.class);

    // 主入口
    @Transactional
    public void excute(Map<String, String> params){
        System.out.println("===> createfamilyservice: "+ params.toString());
        // 查询用户信息

        // 创建家庭信息

        // 更新用户信息
        // 已有首页圈子则不更新改信息

        return;
    }
}
