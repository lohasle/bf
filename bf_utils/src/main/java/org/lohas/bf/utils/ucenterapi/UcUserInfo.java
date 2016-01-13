package org.lohas.bf.utils.ucenterapi;

import java.util.LinkedList;

/**
 * Created by lohas on 2015/2/3.
 * ucenter 用户对象
 */
public class UcUserInfo {
    private Integer uid;
    private String userName;
    private String pwd;
    private String email;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static UcUserInfo getUcUserInfo(String userInfo) {
        UcUserInfo ucUserInfo = new UcUserInfo();
        if (ucUserInfo != null) {
            LinkedList<String> rs = XMLHelper.uc_unserialize(userInfo);
            ucUserInfo.setUid(Integer.parseInt(rs.get(0)));
            ucUserInfo.setUserName(rs.get(1));
            ucUserInfo.setPwd(rs.get(2));
            ucUserInfo.setEmail(rs.get(3));
        }
        return ucUserInfo;
    }
}
