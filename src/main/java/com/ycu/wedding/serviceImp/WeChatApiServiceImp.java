package com.ycu.wedding.serviceImp;

import com.ycu.wedding.pojo.customClass.*;
import com.ycu.wedding.service.WeChatApiService;
import com.ycu.wedding.util.WeChatApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;


@Service
public class WeChatApiServiceImp implements WeChatApiService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private WeChatApiClient weChatApiClient;

    // Redis 缓存的 key 前缀
    private static final String ACCESS_TOKEN_KEY_PREFIX = "wechat:access_token:";

    // 获取缓存中的 access_token 数据（String）
    /*private String getCachedToken(String code) {
        String key = ACCESS_TOKEN_KEY_PREFIX + code;
        String access_token = (String) redisTemplate.opsForValue().get(key);
        return access_token;
    }*/

    // 获取缓存中的 access_token 数据(对象形式)
    private WeChatTokenData getCachedToken(String code) {
        String key = ACCESS_TOKEN_KEY_PREFIX + code;
        WeChatTokenData  tokenData = (WeChatTokenData ) redisTemplate.opsForValue().get(key);
        return tokenData;
    }

    // 存储 access_token 到 Redis 中
    private void cacheToken(String code, WeChatTokenData tokenData) {
        String key = ACCESS_TOKEN_KEY_PREFIX + code;
        redisTemplate.opsForValue().set(key, tokenData,
                tokenData.getExpiresAt() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    // 获取有效的 access_token
    public WeChatAccessToken getAccessToken(String code) {
        //  获取缓存中的 token 数据
        WeChatTokenData tokenData = getCachedToken(code);
        if (tokenData == null) {
//            throw new RuntimeException("Token data not found in cache");

            // todo
        }

        //  检查 access_token 是否过期
        if (tokenData.isAccessTokenExpired()) {
            //  如果过期，使用 refresh_token 刷新 access_token
            return refreshAccessToken(tokenData.getRefresh_token(),code);
        } else if (tokenData.isAccessTokenExpiringSoon()) {
            //  如果 access_token 将在 10 分钟内过期，则使用 refresh_token 刷新 access_token
            return refreshAccessToken(tokenData.getRefresh_token(),code);
        } else {
            //  如果 access_token 仍然有效，直接返回
            return new WeChatAccessToken(tokenData.getAccess_token());
        }
    }

    @Override
    public WeChatAccessToken refreshAccessToken(String refresh_token,String code) {

        //  使用 refresh_token 调用微信接口获取新的 access_token
        WeChatRefreshToken refreshTokenResponse = weChatApiClient.refreshAccessToken(refresh_token);
        WeChatAccessToken weChatAccessToken = new WeChatAccessToken(
                refreshTokenResponse.getAccess_token(),
                refreshTokenResponse.getExpires_in(),
                refresh_token
        );

        //  创建新的 token 数据并更新缓存
        WeChatTokenData newTokenData = new WeChatTokenData();
        newTokenData.setAccess_token(newTokenData.getAccess_token());
        newTokenData.setRefresh_token(refresh_token);  // 假设 refresh_token 不会变化
        newTokenData.setExpiresAt(System.currentTimeMillis() + Long.parseLong(weChatAccessToken.getExpires_in()) * 1000L);

        //  更新 Redis 中的缓存
        cacheToken(code, newTokenData);    // todo? refresh_token做参数，则key就变了吧，一开始用的是code

        return weChatAccessToken;
    }
}
