package com.ycu.wedding.controller;

import com.ycu.wedding.pojo.customClass.ApiResponse;
import com.ycu.wedding.pojo.User;
import com.ycu.wedding.serviceImp.UserServiceImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/marry/user")
public class UserController {
    private static final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserServiceImp userServiceImp;
    /**
     * 新增用户
     * @param user 请求参数，包含用户的基本信息和 Base64 编码的头像
     * @return ApiResponse 返回操作结果
     */
    @PostMapping("/add")
    public ApiResponse addUser(@RequestBody User user) {

        long timestamp1 = System.currentTimeMillis();

        try {
            int index = userServiceImp.addUser(user);
            if (index > 0) {

                long timestamp2 = System.currentTimeMillis();
                return ApiResponse.success(user, "用户新增成功"+
                        " 接口用时："+(timestamp2-timestamp1));
            } else {
                long timestamp2 = System.currentTimeMillis();
                return ApiResponse.failure(500, "用户新增失败，数据库操作未成功"+
                        " 接口用时："+(timestamp2-timestamp1));
            }
        } catch (IOException e) {
            // 处理文件保存或解码失败的异常
//            e.printStackTrace();
            log.error("qqq,文件处理异常",e);
            long timestamp2 = System.currentTimeMillis();
            // 新增失败，返回失败的响应
            return ApiResponse.failure(500, "用户新增失败，文件处理异常"+
                    " 接口用时："+(timestamp2-timestamp1));
        } catch (Exception e) {
            // 其他异常情况
//            e.printStackTrace();
            log.error("qqq,内部执行错误",e);
            long timestamp2 = System.currentTimeMillis();
            return ApiResponse.failure(500, "用户新增失败，内部执行错误" +
                    " 接口用时："+(timestamp2-timestamp1));
        }
    }

    @GetMapping("/getToken")
    public ApiResponse getToken(String code,String access_token) {
        long timestamp1 = System.currentTimeMillis();

        String urlStr =
                "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

        long timestamp2 = System.currentTimeMillis();
        String usedTime = " 接口用时："+(timestamp2-timestamp1);
        return null;
    }
}
