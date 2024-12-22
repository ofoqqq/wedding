package com.ycu.wedding.service;

import com.ycu.wedding.pojo.User;

import java.io.IOException;

public interface UserService {

    int addUser(User user)throws IOException;
}
