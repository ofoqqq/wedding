package com.ycu.wedding.pojo.customClass;

/**
 * refreshtoken接口返回数据类
 */
public class WeChatRefreshToken {
    private String access_token;
    private String expires_in;  // access_token接口调用凭证超时时间，单位（秒）
    private String refresh_token;
    private String openid;
    private String scope; // 用户授权的作用域，使用逗号（,）分隔
    private Integer errcode;   // 用于接收错误代码
    private String errmsg; // 用于接收错误消息

    public WeChatRefreshToken(){
    }

    public WeChatRefreshToken(Integer errcode,String errmsg) {
    }

    public WeChatRefreshToken(String access_token, String expires_in, String refresh_token, String openid, String scope) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
        this.openid = openid;
        this.scope = scope;
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
        return "WeChatRefreshToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
