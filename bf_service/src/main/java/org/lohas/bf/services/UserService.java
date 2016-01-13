package org.lohas.bf.services;

import org.lohas.bf.dao.entities.SnsUser;
import org.lohas.bf.pojo.LoginUserBean;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.services.base.BasicService;

import java.util.Map;

/**
 * Created by fule https:github.com/lohasle on 2016/1/13 0013.
 */
public interface UserService extends BasicService {

    /**
     * 登录接口
     *
     * @return
     */
    Message login(LoginUserBean userBean);

    /**
     * 登出
     *
     * @param userId
     * @return
     */
    Message loginOut(String userId);


    /**
     * 登录检查
     *
     * @param userBean
     * @return
     */
    Message checkLogin(LoginUserBean userBean);


    /**
     * 注册接口
     *
     * @return
     */
    Message register(Map map);


    /**
     * 获取用户信息
     *
     * @return
     */
    Message getUser(String userId);

    /**
     * 更新用户信息
     *
     * @return
     */
    Message updateUser(SnsUser snsUser);

    /**
     * 刷新token
     *
     * @return
     */
    Message refreshToken(String oldToken);

}
