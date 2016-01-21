package org.lohas.bf.security;


import org.lohas.bf.dao.entities.SnsUser;

import java.util.Map;

/**
 * Created by lohas on 2015/7/7.
 * https://github.com/lohasle
 * httpSession 中的session 访问key
 */
public enum HttpSessionKey {




    // 业务session  暂存
    TEMP_GENERAL("CAPTCHA_SESSION_KEY", String.class), //验证码
    TEMP_REG_YZM("TEMP_REG_YZM", Map.class),  // 注册验证码 {val:"",createDate:"",smsId:""}
    TEMP_REG_DOCTOR("TEMP_REG_DOCTOR", Map.class),  // 注册session 缓存的医生 {phone:"",pwd:""}
    USER_GENERAL("GENERAL_USER", SnsUser.class),     // app 和网站前端用户


    TEMP_FORGOTPWD_YZM("TEMP_FORGOTPWD_YZM", Map.class),  // 找回密码验证码 {val:"",createDate:"",smsId:""}
    TEMP_REG_USER("TEMP_REG_USER", Map.class),  // 注册session 缓存的用户 {phone:"",pwd:""}
    TEMP_WX_OPEN_ID("TEMP_WX_OPEN_ID", String.class),  // 微信 openId

    ;


    private final String name;

    private final Class valueType;

    HttpSessionKey(String name, Class valueType) {
        this.name = name;
        this.valueType = valueType;
    }

    public String getName() {
        return name;
    }

    public Class getValueType() {
        return valueType;
    }

}
