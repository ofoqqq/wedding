package com.ycu.wedding.serviceImp;

import com.ycu.wedding.pojo.customClass.WeChatAccessToken;
import com.ycu.wedding.pojo.customClass.WeChatConfig;
import com.ycu.wedding.pojo.customClass.WeChatRefreshToken;
import com.ycu.wedding.service.WeChatApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeChatApiServiceImp implements WeChatApiService {

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public WeChatAccessToken getWeChatAccessToken() {
        String url = UriComponentsBuilder.fromHttpUrl(weChatConfig.getAccessTokenUrl())
                .queryParam("appid", weChatConfig.getAppid())
                .queryParam("secret", weChatConfig.getSecret())
                .queryParam("code", code)
                .queryParam("grant_type", "authorization_code")
                .toUriString();

        return restTemplate.getForObject(url, WeChatAccessToken.class);
    }

    @Override
    public WeChatRefreshToken getWeChatRefreshToken() {
        return null;
    }
}
