package com.ycu.wedding.service;

import com.ycu.wedding.pojo.customClass.WeChatAccessToken;
import com.ycu.wedding.pojo.customClass.WeChatRefreshToken;

public interface WeChatApiService {

    WeChatAccessToken getWeChatAccessToken();

    WeChatRefreshToken getWeChatRefreshToken();
}
