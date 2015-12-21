package org.lohas.bf.utils.wx.bean;

import java.util.Date;

/**
 * Created by lohas on 2015/7/9.
 * https://github.com/lohasle
 * 需要缓存微信的一些凭证信息
 */
public class WxCacheInfo {

    /**
     * 微信服务 token 过期时间  7200 秒
     */
    public static final int expires_in = 7200;

    /**
     * accessToken accessToken
     */
    private String accessToken;

    /**
     * jsapiTicket  js sdk ticket  此凭据 过期时间 官方也是7200
     */
    private String jsapiTicket;

    /**
     * 缓存创建时间
     */
    private Date createTime;


    public WxCacheInfo() {
    }

    public WxCacheInfo(String accessToken, String jsapiTicket) {
        this.accessToken = accessToken;
        this.jsapiTicket = jsapiTicket;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
