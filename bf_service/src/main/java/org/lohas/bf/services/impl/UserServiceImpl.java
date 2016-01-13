package org.lohas.bf.services.impl;

import org.lohas.bf.dao.entities.SnsUser;
import org.lohas.bf.dao.mapper.SnsUserMapper;
import org.lohas.bf.pojo.LoginUserBean;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.services.UserService;
import org.lohas.bf.services.base.BasicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by fule https:github.com/lohasle on 2016/1/13 0013.
 */
@Service
public class UserServiceImpl  extends BasicServiceImpl implements UserService {

    @Autowired
    private SnsUserMapper snsUserMapper;

    /**
     * 登录接口
     *
     * @param userBean
     * @return
     */
    @Override
    public Message login(LoginUserBean userBean) {
        return null;
    }

    /**
     * 登出
     *
     * @param userId
     * @return
     */
    @Override
    public Message loginOut(String userId) {
        return null;
    }

    /**
     * 登录检查
     *
     * @param userBean
     * @return
     */
    @Override
    public Message checkLogin(LoginUserBean userBean) {
        return null;
    }

    /**
     * 注册接口
     *
     * @param map
     * @return
     */
    @Override
    public Message register(Map map) {
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Message getUser(String userId) {
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param snsUser
     * @return
     */
    @Override
    public Message updateUser(SnsUser snsUser) {
        return null;
    }

    /**
     * 刷新token
     *
     * @param oldToken
     * @return
     */
    @Override
    public Message refreshToken(String oldToken) {
        return null;
    }
}
