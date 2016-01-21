package org.lohas.bf.pojo;

import org.apache.commons.net.util.Base64;
import org.lohas.bf.utils.qq.User;
import org.lohas.bf.utils.wx.bean.WxUserInfo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lohas on 2015/1/31.
 * 登录数据
 */
public class LoginUserBean implements Serializable {

    //来源 本机
    public static final String FROM_NATIVE = "native"; // app
    public static final String FROM_WECHAT = "wechat";
    public static final String FROM_QQ = "qq";
    public static final String FROM_WEIBO = "weibo";
    public static final String FROM_WEBSITE = "website"; // 网站

    //用户名
    private String userName;
    //电话号码
    private String phone;
    //密码(经过base64加密过的密码)
    private String password;
    //经度
    private BigDecimal lng;
    //维度
    private BigDecimal lat;
    //最后一次登录ip
    private String lastLoginIp;
    //来源 默认 什么都不处理
    private String from;


    //个推的客户端id  用于推送
    private String gtCid;

    // 城市ID
    private Integer regionId;


    //ext   第三方  微信账号
    private WxUserInfo wxUserInfo;

    //qq账号
    private User qqUser;


    /**
     * APP客户端 版本 号
     *
     */
    private String clientVersion;

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }


    public WxUserInfo getWxUserInfo() {
        return wxUserInfo;
    }

    public void setWxUserInfo(WxUserInfo wxUserInfo) {
        this.wxUserInfo = wxUserInfo;
    }

    /**
     * 用户类型   1(用户) / 2（医生）
     */
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // 会话token
    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    /**
     * 经过base64解码的密码
     * @return
     */
    public String getPasswordOnDecodeBase64(){
        String password = new String(Base64.decodeBase64(this.password));
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }


    @Override
    public String toString() {
        return "LoginUserBean{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", token='" + token + '\'' +
                '}';
    }


    public boolean isFrom(String fromStr){
        return  fromStr.equals(this.getFrom());
    }


    public String getGtCid() {
        return gtCid;
    }

    public void setGtCid(String gtCid) {
        this.gtCid = gtCid;
    }




    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public User getQqUser() {
        return qqUser;
    }

    public void setQqUser(User qqUser) {
        this.qqUser = qqUser;
    }
}
