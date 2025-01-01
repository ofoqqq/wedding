package com.ycu.wedding.pojo.customClass;

/**
 * accesstoken接口返回数据类
 */
public class WeChatAccessToken {
    private String access_token;
    private String expires_in;  // access_token接口调用凭证超时时间，单位（秒）
    private String refresh_token;
    private String openid;
    private String scope; // 用户授权的作用域，使用逗号（,）分隔
    private String unionid;   // 当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
    private Integer errcode;   // 用于接收错误代码
    private String errmsg; // 用于接收错误消息

    public WeChatAccessToken() {
    }

    public WeChatAccessToken(Integer errcode,String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public WeChatAccessToken(String access_token, String expires_in, String refresh_token, String openid, String scope, String unionid) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
        this.openid = openid;
        this.scope = scope;
        this.unionid = unionid;
    }

    public WeChatAccessToken(String accessToken, String expiresIn, String refreshToken) {
        this.access_token = accessToken;
        this.expires_in = expiresIn;
        this.refresh_token = refreshToken;
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

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "WeChatAccessToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                ", unionid='" + unionid + '\'' +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
