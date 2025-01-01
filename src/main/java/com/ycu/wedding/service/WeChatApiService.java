package com.ycu.wedding.service;

import com.ycu.wedding.pojo.customClass.WeChatAccessToken;
import com.ycu.wedding.pojo.customClass.WeChatRefreshToken;

public interface WeChatApiService {

    // 根据code获取accesstoken
    WeChatAccessToken getAccessToken(String code);

    // 刷新accesstoken或获取一个新的
    WeChatAccessToken refreshAccessToken(String refreshToken);
}
