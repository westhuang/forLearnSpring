package com.west.forlearn.dao.mapper;

import com.west.forlearn.dao.FamilyInfo;
import org.apache.ibatis.annotations.*;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

public interface FamilyMapper {

    // 查询家庭信息
    @Select("SELECT Ffid,Fname,Fbackurl,Fcreate_user,Fuser_num,Fuser_list,Fstate,Fsign," +
            "Fcreate_time,Fmodify_time,Fstanby1,Fstanby2,Fstanby3,Fstanby4,Fstanby5,Fstanby6,Fstanby7,Fstanby8 " +
            "FROM fb_db.t_family WHERE Ffid=#{fid} limit 2")
    @Results({
            @Result(property = "fid", column = "Ffid"),
            @Result(property = "name", column = "Fname"),
            @Result(property = "backurl", column = "Fbackurl"),
            @Result(property = "createUser", column = "Fcreate_user"),
            @Result(property = "userNum", column = "Fuser_num"),
            @Result(property = "userList", column = "Fuser_list"),
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
    List<FamilyInfo> queryFamilyInfo(String fid);

    // 查询家庭信息，加锁
    @Select("SELECT Ffid,Fname,Fbackurl,Fcreate_user,Fuser_num,Fuser_list,Fstate,Fsign," +
            "Fcreate_time,Fmodify_time,Fstanby1,Fstanby2,Fstanby3,Fstanby4,Fstanby5,Fstanby6,Fstanby7,Fstanby8 " +
            "FROM fb_db.t_family WHERE Ffid=#{fid} limit 2 for update")
    @Results({
            @Result(property = "fid", column = "Ffid"),
            @Result(property = "name", column = "Fname"),
            @Result(property = "backurl", column = "Fbackurl"),
            @Result(property = "createUser", column = "Fcreate_user"),
            @Result(property = "userNum", column = "Fuser_num"),
            @Result(property = "userList", column = "Fuser_list"),
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
    List<FamilyInfo> queryFamilyInfoLock(String fid);

    // 插入用户信息
    @Insert("INSERT INTO fb_db.t_family SET Fname=#{name},Fbackurl=#{backurl},Fcreate_user=#{createUser},Fuser_num=#{userNum}," +
            "Fuser_list=#{userList},Fstate=#{state},Fsign=#{sign},Fcreate_time=now()")
    @Options(useGeneratedKeys = true, keyProperty = "fid", keyColumn = "Ffid")
    int insertFamilyInfo(FamilyInfo familyInfo);

    // 更新用户信息
    @Update("UPDATE fb_db.t_family SET Fname=#{name},Fbackurl=#{backurl},Fuser_num=#{userNum}," +
            "Fuser_list=#{userList},Fstate=#{state},Fsign=#{sign} where Fopenid=#{openid} limit 2")
    int updateFamilyInfo(FamilyInfo familyInfo);

}
