package com.west.forlearn.dao.mapper;

import com.west.forlearn.dao.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM simple_user WHERE Fbkid=#{id}")
    @Results({
            @Result(property = "id", column = "Fbkid"),
            @Result(property = "name", column = "Fname"),
            @Result(property = "desc", column = "Fdesc")
    })
    UserEntity findOneMybatis(Long id);

    @Insert("INSERT INTO simple_user(Fbkid, Fname, Fdesc) VALUES(#{id}, #{name}, #{desc})")
    UserEntity saveMybatis(UserEntity user);

    @Select("SELECT * FROM simple_user WHERE Fname=#{name}")
    @Results({
            @Result(property = "id", column = "Fbkid"),
            @Result(property = "name", column = "Fname"),
            @Result(property = "desc", column = "Fdesc")
    })
    UserEntity findUserByNameMybatis(String name);
}
