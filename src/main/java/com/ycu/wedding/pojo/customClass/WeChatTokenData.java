package com.ycu.wedding.pojo.customClass;

public class WeChatTokenData {


    private String access_token;  // 微信的access_token
    private String refresh_token; // 微信的refresh_token
    private long expiresAt;      // access_token 的过期时间点（毫秒）

    public WeChatTokenData() {
    }

    // Getters and setters
    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > expiresAt;
    }

    public boolean isAccessTokenExpiringSoon() {
        return (expiresAt - System.currentTimeMillis()) <= 10 * 60 * 1000; // 10分钟以内
    }

}
