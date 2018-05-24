package com.west.forlearn.dao.mapper;

import com.west.forlearn.dao.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserInfoMapper {

    // 查询用户信息
    @Select("SELECT Fopenid,Fname,Favatar_url,Fgender,Fposition,Ffamily_num,Ffamily_list,Ffirst_fid,Fstate,Fsign," +
            "Fcreate_time,Fmodify_time,Fstanby1,Fstanby2,Fstanby3,Fstanby4,Fstanby5,Fstanby6,Fstanby7,Fstanby8 " +
            "FROM fb_db.t_user WHERE Fopenid=#{openid} limit 2")
    @Results({
            @Result(property = "openid", column = "Fopenid"),
            @Result(property = "name", column = "Fname"),
            @Result(property = "avatarUrl", column = "Favatar_url"),
            @Result(property = "gender", column = "Fgender"),
            @Result(property = "position", column = "Fposition"),
            @Result(property = "familyNum", column = "Ffamily_num"),
            @Result(property = "familyList", column = "Ffamily_list"),
            @Result(property = "firstFid", column = "Ffirst_fid"),
            @Result(property = "state", column = "Fstate"),
            @Result(property = "sign", column = "Fsign"),
            @Result(property = "createTime", column = "Fcreate_time"),
            @Result(property = "modifyTime", column = "Fmodify_time"),
            @Result(property = "standby1", column = "Fstanby1"),
            @Result(property = "standby2", column = "Fstanby2"),
            @Result(property = "standby3", column = "Fstanby3"),
            @Result(property = "standby4", column = "Fstanby4"),
            @Result(property = "standby5", column = "Fstanby5"),
            @Result(property = "standby6", column = "Fstanby6"),
            @Result(property = "standby7", column = "Fstanby7"),
            @Result(property = "standby8", column = "Fstanby8")
    })
    List<UserInfo> queryUserInfo(String openid);

    // 查询用户信息，加锁
    @Select("SELECT Fopenid,Fname,Favatar_url,Fgender,Fposition,Ffamily_num,Ffamily_list,Ffirst_fid,Fstate,Fsign," +
            "Fcreate_time,Fmodify_time,Fstanby1,Fstanby2,Fstanby3,Fstanby4,Fstanby5,Fstanby6,Fstanby7,Fstanby8 " +
            "FROM fb_db.t_user WHERE Fopenid=#{openid} limit 2 for update")
    @Results({
            @Result(property = "openid", column = "Fopenid"),
            @Result(property = "name", column = "Fname"),
            @Result(property = "avatarUrl", column = "Favatar_url"),
            @Result(property = "gender", column = "Fgender"),
            @Result(property = "position", column = "Fposition"),
            @Result(property = "familyNum", column = "Ffamily_num"),
            @Result(property = "familyList", column = "Ffamily_list"),
            @Result(property = "firstFid", column = "Ffirst_fid"),
            @Result(property = "state", column = "Fstate"),
            @Result(property = "sign", column = "Fsign"),
            @Result(property = "createTime", column = "Fcreate_time"),
            @Result(property = "modifyTime", column = "Fmodify_time"),
            @Result(property = "standby1", column = "Fstanby1"),
            @Result(property = "standby2", column = "Fstanby2"),
            @Result(property = "standby3", column = "Fstanby3"),
            @Result(property = "standby4", column = "Fstanby4"),
            @Result(property = "standby5", column = "Fstanby5"),
            @Result(property = "standby6", column = "Fstanby6"),
            @Result(property = "standby7", column = "Fstanby7"),
            @Result(property = "standby8", column = "Fstanby8")
    })
    List<UserInfo> queryUserInfoLock(String openid);

    // 插入用户信息
    @Insert("INSERT INTO fb_db.t_user SET Fopenid=#{openid},Fname=#{name},Favatar_url=#{avatarUrl},Fgender=#{gender},Fposition=#{position}," +
            "Ffamily_num=#{familyNum},Ffamily_list=#{familyList},Ffirst_fid=#{firstFid},Fstate=#{state},Fsign=#{sign},Fcreate_time=now()")
    int insertUserInfo(UserInfo user);

    // 更新用户信息
    @Update("UPDATE fb_db.t_user SET Fname=#{name},Favatar_url=#{avatarUrl},Fgender=#{gender},Fposition=#{position}," +
            "Ffamily_num=#{familyNum},Ffamily_list=#{familyList},Ffirst_fid=#{firstFid},Fstate=#{state},Fsign=#{sign} where Fopenid=#{openid} limit 2")
    int updateUserInfo(UserInfo user);
}
