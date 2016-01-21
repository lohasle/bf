package org.lohas.bf.spring.event.pojo;

import org.lohas.bf.dao.mongomodels.UserModel;

/**
 * Created by fule https:github.com/lohasle on 2016/1/18 0018.
 * 用户更新事件描述
 */
public class UserEvent {

    /**
     * 事件类型创建
     */
    public static final String EVENT_CREATE = "create";

    /**
     * 事件类型修改
     */
    public static final String EVENT_UPDATE = "update";

    /**
     * 操作类型 create update
     */
    private String eventType;

    /**
     * 密码 (新密码)
     */
    private String password;

    /**
     * 用户名  新用户名
     */
    private String userName;

    /**
     * 用户数据
     */
    private UserModel userModel;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public UserEvent() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
