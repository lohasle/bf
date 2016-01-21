package org.lohas.bf.services.impl;

import org.apache.commons.lang.StringUtils;
import org.lohas.bf.constant.Constant;
import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.dao.mongomodels.UserModel;
import org.lohas.bf.pojo.LoginUserBean;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.MessageErrorCode;
import org.lohas.bf.services.UserService;
import org.lohas.bf.services.base.BasicServiceImpl;
import org.lohas.bf.spring.event.pojo.UserEvent;
import org.lohas.bf.utils.MD5Utils;
import org.lohas.bf.utils.qq.User;
import org.lohas.bf.utils.ucenterapi.UcUserInfo;
import org.lohas.bf.utils.ucenterapi.dz.UcAuthCode;
import org.lohas.bf.utils.wx.bean.WxUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * Created by fule https:github.com/lohasle on 2016/1/13 0013.
 */
@Service
public class UserServiceImpl extends BasicServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 全局消息 发布类
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 登录接口
     *
     * @param userBean
     * @return
     */
    @Override
    public Message login(LoginUserBean userBean) {
        if (userBean.isFrom(LoginUserBean.FROM_WECHAT)) {
            // 微信登录
            return loginByWechat(userBean);
        } else if (userBean.isFrom(LoginUserBean.FROM_QQ)) {
            // QQ登录
            return loginByQQ(userBean);
        } else {
            // 非第三方登陆
            if (StringUtils.isBlank(userBean.getPassword())) {
                return new Message(Message.STATE_FALSE, "密码不能为空");
            }

            if (StringUtils.isNotBlank(userBean.getPhone())) {
                // 手机号登录
                return loginByPhone(userBean);

            } else if (StringUtils.isNotBlank(userBean.getUserName())) {
                // 用户名登陆
                return loginByUname(userBean);
            } else {
                return new Message(Message.STATE_FALSE, "用户名或手机号不能为空");
            }
        }
    }

    /**
     * 手机号码登陆
     *
     * @param userBean
     * @return
     */
    @Override
    public Message loginByPhone(LoginUserBean userBean) {
        //电话号码登录情况
        String selectStr = "{phone:'" + userBean.getPhone() + "'}";
        Message message = _loginValid(selectStr, userBean);
        if (message.isSuccess()) {
            return message;
        } else {
            //系统无此用户
            return new Message(Message.STATE_FALSE, MessageErrorCode.SYS_LOGIN_ERROR);
        }
    }

    /**
     * 用户名登录
     *
     * @param userBean
     * @return
     */
    @Override
    public Message loginByUname(LoginUserBean userBean) {
        String selectStr = "{userName:'" + userBean.getUserName() + "'}";
        Message message = _loginValid(selectStr, userBean);
        if (message.isSuccess()) {
            return message;
        } else {
            // todo 系统无此用户 尝试 discuz 登录
            try {
                String userName = userBean.getUserName();
                String pwd = userBean.getPasswordOnDecodeBase64();

                String login_result = uClient.uc_user_login(userName, pwd);
                UcUserInfo ucUserInfo = UcUserInfo.getUcUserInfo(login_result);
                if (ucUserInfo.getUid() != null && ucUserInfo.getUid() > 0) {
                    // 登录ucenter成功 注册本系统用户
                    String salt = String.valueOf(System.currentTimeMillis());
                    UserModel userModel = new UserModel();
                    userModel.setCreateTime(new Date());
                    userModel.setUserName(userName);
                    userModel.setSalt(salt);
                    userModel.setState(Constant.STATE_ENABLE);
                    userModel.setVersion(userBean.getClientVersion());
                    userModel.setUcToken(UcAuthCode.generateToken(userName, pwd, Constant.UC_TOKEN_KEY, ""));
                    userModel.setPwdHash(MD5Utils.encode(pwd, salt));
                    mongoTemplate.save(userBean); // 保存入库


                    // 返回token
                    String avs = userBean.getClientVersion();
                    String uid = userModel.getId();
                    String uName = userModel.getUserName();
                    String avatar = userModel.getAvatar();

                    String token = createToken(uid, uName, avatar, avs, uid);
                    return Message.successWithToken(userModel, token);
                } else {
                    // uc 登录失败
                    return new Message(Message.STATE_FALSE, MessageErrorCode.SYS_LOGIN_NAME_ERROR);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                logger.error("登录ucenter失败");
                throw new ServiceException(getMessage("loginError"));
            }
        }
    }

    /**
     * 微信登录
     *
     * @param userBean
     * @return
     */
    @Override
    public Message loginByWechat(LoginUserBean userBean) {
        WxUserInfo wxUserInfo = userBean.getWxUserInfo();
        //check
        if (StringUtils.isBlank(wxUserInfo.getUnionid())) {
            logger.debug("wx---->非法授权");
            return new Message(Message.STATE_FALSE, "非法授权");
        }
        String openid = wxUserInfo.getOpenid();
        String selectStr = "{wechatOpenId:'" + openid + "'}";
        Message message = _loginValid(selectStr, userBean);
        if (message.isSuccess()) {
            return message;
        } else {
            // 注册
            String nickname = wxUserInfo.getNickname();
            if (nickname.length() > 4) {
                wxUserInfo.setNickname(nickname.substring(0, 4));
            }
            try {
                applicationEventPublisher.publishEvent(wxUserInfo);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new ServiceException("微信第三方注册失败");
            }

            Message afterMsg = _loginValid(selectStr, userBean);
            if (afterMsg.isSuccess()) {
                return afterMsg;
            }

            return new Message(Message.STATE_FALSE, MessageErrorCode.SYS_LOGIN_WECHAT_ERROR);
        }
    }

    /**
     * QQ登录
     *
     * @param userBean
     * @return
     */
    @Override
    public Message loginByQQ(LoginUserBean userBean) {
        User qqUser = userBean.getQqUser();
        //check
        if (StringUtils.isBlank(qqUser.getOpenid())) {
            logger.debug("wx---->非法授权");
            return new Message(Message.STATE_FALSE, "非法授权");
        }
        String openid = qqUser.getOpenid();
        String selectStr = "{qqOpenId:'" + openid + "'}";
        Message message = _loginValid(selectStr, userBean);
        if (message.isSuccess()) {
            return message;
        } else {
            // 注册
            String nickname = qqUser.getNickname();
            if (nickname.length() > 4) {
                qqUser.setNickname(nickname.substring(0, 4));
            }
            try {
                applicationEventPublisher.publishEvent(qqUser);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new ServiceException("QQ第三方注册失败");
            }

            Message afterMsg = _loginValid(selectStr, userBean);
            if (afterMsg.isSuccess()) {
                return afterMsg;
            }
            return new Message(Message.STATE_FALSE, MessageErrorCode.SYS_LOGIN_QQ_ERROR);
        }
    }

    // 登录
    private Message _loginValid(String selectStr, LoginUserBean userBean) {
        //电话号码登录情况
        String filedStr = UserModel.FIELDS_LOGIN;
        Query query = new BasicQuery(selectStr, filedStr);
        UserModel userModel = mongoTemplate.findOne(query, UserModel.class);

        String password = userBean.getPasswordOnDecodeBase64();
        if (userModel != null && userModel.validatePwd(password)) {

            String avs = userBean.getClientVersion();

            String uid = userModel.getId();
            String uName = userModel.getUserName();
            String avatar = userModel.getAvatar();

            String token = createToken(uid, uName, avatar, avs, uid);

            return Message.successWithToken(userModel.simple(), token);
        } else {
            //系统无此用户
            return new Message(Message.STATE_FALSE);
        }
    }

    /**
     *
     * 登出
     *
     * @param userId
     * @return
     */
    @Override
    public Message loginOut(String userId) {
        return new Message(Message.STATE_TRUE, "退出成功");
    }


    /**
     * 注册接口
     *
     * @param
     * @return
     */
    @Override
    public Message registerByPhone(String phone, String password) {
        String salt = String.valueOf(System.currentTimeMillis());

        UserModel userModel = new UserModel();
        userModel.setCreateTime(new Date());
        userModel.setPhone(phone);
        userModel.setPwdHash(MD5Utils.encode(password, salt));

        try {
            mongoTemplate.save(userModel);
            String uid = userModel.getId();
            String token = createToken(uid, "", "", "", "");
            return Message.successWithToken(userModel, token);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("注册失败");
        }
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public Message<UserModel> getUser(String userId) {
        String selectStr = "{_id:'" + userId + "'}";
        String filedStr = UserModel.FIELDS_INFO;
        Query query = new BasicQuery(selectStr, filedStr);
        UserModel userModel = mongoTemplate.findOne(query, UserModel.class);
        return new Message(Message.STATE_TRUE, userModel);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Message updateUser(UserModel user,Map map) {

        UserModel upUser = getUser(user.getId()).getData();// 元数据

        String userName = user.getUserName();

        // check 排除自身和已有用户名
        if(StringUtils.isNotBlank(userName)&&!userName.equals(upUser.getUserName())){
            long count = mongoTemplate.count(new BasicQuery("{userName:'" + userName + "'}"), UserModel.class);
            if(count>0){
                return new Message(Message.STATE_FALSE,"用户名"+userName+"已存在");
            }
        }

        Update update = new Update();
        if(StringUtils.isNotBlank(user.getSex())){
            update.set("sex",user.getSex());
        }
        if(StringUtils.isNotBlank(user.getAvatar())){
            update.set("avatar",user.getAvatar());
        }
        if(user.getBirthDate()!=null){
            update.set("birthDate",user.getBirthDate());
        }
        if(user.getPhone()!=null){
            update.set("phone",user.getPhone());
        }
        try {
            String pwd = map.get("password").toString();// 修改的密码
            if((StringUtils.isNotBlank(userName))||StringUtils.isNotBlank(pwd)){
                // 修改密码或者用户名，同步更新到ucenter
                UserEvent userEvent = new UserEvent();
                userEvent.setUserModel(upUser);

                if(StringUtils.isBlank(upUser.getUcToken())){
                    // ucenter 新增
                    userEvent.setEventType(UserEvent.EVENT_CREATE);
                }else{
                    // ucenter 更新
                    userEvent.setEventType(UserEvent.EVENT_UPDATE);
                }

                userEvent.setPassword(pwd);
                userEvent.setUserName(userName);
                applicationEventPublisher.publishEvent(userEvent);  // 内部会自动更新 用户名和密码相关
            }
            upUser.setModifyTime(new Date());
            mongoTemplate.updateFirst(new BasicQuery("{_id:'" + upUser.getId() + "'}"),update,UserModel.class); // 更新

            UserModel upUserOver = getUser(user.getId()).getData();// 读取新数据

            // 返回token
            String avs = map.get("clientVersion").toString();
            String uid = upUserOver.getId();
            String uName = upUserOver.getUserName();
            String avatar = upUserOver.getAvatar();

            String token = createToken(uid, uName, avatar, avs, uid);
            Message message = Message.successWithToken(upUser,token);
            return message;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new ServiceException("修改失败");
        }

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

    /**
     * 电话号码是否存在
     * 存在 return true
     *
     * @param phone
     * @return
     */
    @Override
    public boolean userExistByPhone(String phone) {
        String selectStr = "{phone:'" + phone + "'}";
        Query query = new BasicQuery(selectStr);
        long count = mongoTemplate.count(query, UserModel.class);
        return count > 0;
    }
}
