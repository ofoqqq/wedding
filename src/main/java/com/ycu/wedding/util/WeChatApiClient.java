package com.ycu.wedding.util;

import com.ycu.wedding.pojo.customClass.WeChatAccessToken;
import com.ycu.wedding.pojo.customClass.WeChatConfig;
import com.ycu.wedding.pojo.customClass.WeChatRefreshToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 用来处理与微信 API 的交互
 * 包含api:
 * 获取access_token
 * 获取refresh_token
 */
@Component
public class WeChatApiClient {
    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private RestTemplate restTemplate;

    public WeChatAccessToken getAccessToken(String code) {
        String url = UriComponentsBuilder.fromHttpUrl(weChatConfig.getAccessTokenUrl())
                .queryParam("appid", weChatConfig.getAppid())
                .queryParam("secret", weChatConfig.getSecret())
                .queryParam("code", code)
                .queryParam("grant_type", "authorization_code")
                .toUriString();

        return restTemplate.getForObject(url, WeChatAccessToken.class);
    }

    public WeChatRefreshToken refreshAccessToken(String refreshToken) {
        String url = UriComponentsBuilder.fromHttpUrl(weChatConfig.getRefreshTokenUrl())
                .queryParam("appid", weChatConfig.getAppid())
                .queryParam("grant_type", "refresh_token")
                .queryParam("refresh_token", refreshToken)
                .toUriString();

        return restTemplate.getForObject(url, WeChatRefreshToken.class);
    }
}
