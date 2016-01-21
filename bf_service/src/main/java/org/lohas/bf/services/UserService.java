package org.lohas.bf.services;

import org.lohas.bf.dao.mongomodels.UserModel;
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
     * 手机号码登陆
     * @param userBean
     * @return
     */
    Message loginByPhone(LoginUserBean userBean);

    /**
     * 用户名登录
     * @param userBean
     * @return
     */
    Message loginByUname(LoginUserBean userBean);


    /**
     * 微信登录
     * @param userBean
     * @return
     */
    Message loginByWechat(LoginUserBean userBean);

    /**
     * QQ登录
     * @param userBean
     * @return
     */
    Message loginByQQ(LoginUserBean userBean);

    /**
     * 登出
     *
     * @param userId
     * @return
     */
    Message loginOut(String userId);



    /**
     * 注册接口
     *
     * @return
     */
    Message registerByPhone(String phone,String password);


    /**
     * 获取用户信息
     *
     * @return
     */
    Message<UserModel> getUser(String userId);

    /**
     * 更新用户信息
     * @param user  更新的用户信息
     * @param map   jwt  相关参数
     * @return
     */
    Message updateUser(UserModel user,Map map);

    /**
     * 刷新token
     *
     * @return
     */
    Message refreshToken(String oldToken);

    /**
     * 电话号码是否存在
     * @param phone
     * @return
     */
    boolean userExistByPhone(String phone);
}
