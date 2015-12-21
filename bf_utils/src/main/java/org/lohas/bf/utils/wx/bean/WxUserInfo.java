package org.lohas.bf.utils.wx.bean;

import java.util.List;

/**
 * Created by lohas on 2015/4/14.
 * https://github.com/lohasle
 * 微信用户消息
 */
public class WxUserInfo {

    //男
    public static final String SEX_MATE = "1";
    //女
    public static final String SEX_FEMALE = "2";
    //位置
    public static final String SEX_UNKNOW = "0";

    private String openid;
    private String nickname;
    private String sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private List<String> privilege;
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }


    public String getSexZhCn() {
        if (SEX_MATE.equals(this.sex)) {
            return "男";
        } else if (SEX_FEMALE.equals(this.sex)) {
            return "女";
        } else  {
            return null;
        }
    }
}
