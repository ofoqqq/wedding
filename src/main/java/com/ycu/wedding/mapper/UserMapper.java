package com.ycu.wedding.mapper;

import com.ycu.wedding.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

    @Insert("INSERT into user\n" +
            "(openid,avatar,name)\n" +
            "VALUES\n" +
            "(#{openid}, #{avatar}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    /*@Insert("INSERT into user\n" +
            "(openid,avatar,name)\n" +
            "VALUES\n" +
            "(#{openid}, #{avatar}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUserInit(User user);*/
}
