package com.ycu.wedding.pojo.customClass;

public class WeChatRefreshToken {
    private String access_token;
    private String expires_in;  // access_token接口调用凭证超时时间，单位（秒）
    private long refresh_token;
    private long openid;
    private long scope; // 用户授权的作用域，使用逗号（,）分隔

    public WeChatRefreshToken(String access_token, long scope, long openid, long refresh_token, String expires_in) {
        this.access_token = access_token;
        this.scope = scope;
        this.openid = openid;
        this.refresh_token = refresh_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public long getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(long refresh_token) {
        this.refresh_token = refresh_token;
    }

    public long getOpenid() {
        return openid;
    }

    public void setOpenid(long openid) {
        this.openid = openid;
    }

    public long getScope() {
        return scope;
    }

    public void setScope(long scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "WeChatRefreshToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", refresh_token=" + refresh_token +
                ", openid=" + openid +
                ", scope=" + scope +
                '}';
    }
}
