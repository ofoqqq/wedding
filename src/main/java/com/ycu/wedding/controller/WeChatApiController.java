package com.ycu.wedding.controller;

import com.ycu.wedding.pojo.customClass.ApiResponse;
import com.ycu.wedding.pojo.customClass.WeChatAccessToken;
import com.ycu.wedding.pojo.customClass.WeChatAccessTokenFailure;
import com.ycu.wedding.pojo.customClass.WeChatAccessTokenSuccess;
import com.ycu.wedding.serviceImp.WeChatApiServiceImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/marry/wx")
public class WeChatApiController {

    private static final Logger log = LogManager.getLogger(WeChatApiController.class);

    @Autowired
    WeChatApiServiceImp weChatApiServiceImp;

    @GetMapping("/getToken")
    public ApiResponse getToken(@RequestParam String code, @RequestParam(required = false) String access_token
            , @RequestParam(required = false) String refreshToken) {

        WeChatAccessToken weChatAccessToken = weChatApiServiceImp.getAccessToken(code);
        log.error("\nqqq,weChatAccessToken: " + weChatAccessToken);

        if (weChatAccessToken.getErrcode() == null) {   // 微信接口未返回错误码
            WeChatAccessTokenSuccess wts = new WeChatAccessTokenSuccess(
                    weChatAccessToken.getAccess_token(),
                    weChatAccessToken.getExpires_in(),
                    weChatAccessToken.getRefresh_token(),
                    weChatAccessToken.getOpenid(),
                    weChatAccessToken.getScope(),
                    weChatAccessToken.getUnionid()
            );
            return ApiResponse.success(wts, "获取access_token成功");
        } else {    // 有错误码

            WeChatAccessTokenFailure wtf = new WeChatAccessTokenFailure(
                    weChatAccessToken.getErrcode(), weChatAccessToken.getErrmsg()
            );
            log.error("\nqqq,WeChatAccessTokenFailure: " + wtf);
            return ApiResponse.success(wtf, "获取access_token失败");
        }

    }
}
