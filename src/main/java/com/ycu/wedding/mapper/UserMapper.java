package com.ycu.wedding.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    @Insert("INSERT into user\n" +
            "(userOpenid,userAvatar,userName)\n" +
            "VALUES\n" +
            "(#{openid},#{avatar},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(@Param("openid") String openid, @Param("avatar") String avatar,@Param("name") String name);
}
