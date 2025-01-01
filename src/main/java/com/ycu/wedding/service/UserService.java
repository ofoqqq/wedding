package com.ycu.wedding.service;

import com.ycu.wedding.pojo.User;

import java.io.IOException;

public interface UserService {

    // 新注册用户存入数据库
    int addUser(User user)throws IOException;
}
