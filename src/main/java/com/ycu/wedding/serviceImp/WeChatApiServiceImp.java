package com.ycu.wedding.serviceImp;

import com.ycu.wedding.pojo.customClass.WeChatAccessToken;
import com.ycu.wedding.pojo.customClass.WeChatConfig;
import com.ycu.wedding.pojo.customClass.WeChatRefreshToken;
import com.ycu.wedding.service.WeChatApiService;
import com.ycu.wedding.util.WeChatApiClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeChatApiServiceImp implements WeChatApiService {

    @Autowired
    private WeChatApiClient weChatApiClient;

    @Override
    public WeChatAccessToken getAccessToken(String code) {
        return weChatApiClient.getAccessToken(code);
    }

    @Override
    public WeChatAccessToken refreshAccessToken(String refreshToken) {
        WeChatRefreshToken refreshTokenResponse = weChatApiClient.refreshAccessToken(refreshToken);
        return new WeChatAccessToken(
                refreshTokenResponse.getAccess_token(),
                refreshTokenResponse.getExpires_in(),
                refreshToken
        );
    }

    /*public WeChatRefreshToken refreshAccessToken(String refreshToken) {

        return weChatApiClient.refreshAccessToken(refreshToken);
    }*/
}
