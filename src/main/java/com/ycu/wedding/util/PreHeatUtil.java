package com.ycu.wedding.util;

import com.ycu.wedding.controller.UserController;
import com.ycu.wedding.mapper.UserMapper;
import com.ycu.wedding.pojo.User;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PreHeatUtil {

    private static final Logger log = LogManager.getLogger(PreHeatUtil.class);

    @Autowired
    UserMapper userMapper;

   /* @PostConstruct
    public void init() {    // 初始化执行
        User user = new User();
        user.setOpenid("testOpenid1");
        user.setName("testName1");
        user.setAvatar("testAvatar1");
        int index = userMapper.insertUserInit(user);    // index为返回行数
        int id = user.getId();
        log.error("\nqqq,初始化成功，id："+id);
    }*/
}
