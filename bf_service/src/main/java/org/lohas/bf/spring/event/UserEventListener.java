package org.lohas.bf.spring.event;

import org.apache.commons.lang.StringUtils;
import org.lohas.bf.constant.Constant;
import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.dao.mongomodels.UserModel;
import org.lohas.bf.pojo.MessageErrorCode;
import org.lohas.bf.services.CommonService;
import org.lohas.bf.spring.event.pojo.UserEvent;
import org.lohas.bf.utils.MD5Utils;
import org.lohas.bf.utils.StringUtil;
import org.lohas.bf.utils.qq.User;
import org.lohas.bf.utils.ucenterapi.dz.UcAuthCode;
import org.lohas.bf.utils.wx.bean.WxUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * Created by fule https:github.com/lohasle on 2016/1/18 0018.
 * 用户更新事件  监听器
 */
@Component
public class UserEventListener {


    private static Logger logger = LoggerFactory.getLogger(UserEventListener.class);


    @Autowired
    private CommonService commonService;


    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 更新监听事件
     *
     * @param ue
     */
    @EventListener(condition = "#ue.userModel!=null and #ue.eventType!=null")
    public void updateEventListener(UserEvent ue) {

        String userName = ue.getUserName(); // 新用户名
        String password = ue.getPassword(); // 新密码
        UserModel userModel = ue.getUserModel();

        String eventType = ue.getEventType();


        if (UserEvent.EVENT_UPDATE.equals(eventType)) {


            // 更新 UC 用户名
            String ucToken = userModel.getUcToken();
            if (StringUtils.isNotBlank(userName)) {// 修改用户名
                commonService.ucSynChangeName(userName, ucToken);
            }
            if (StringUtils.isNotBlank(password)) {// 修改密码
                commonService.ucUserSynRepwd(password, ucToken);
            }

        } else if (UserEvent.EVENT_CREATE.equals(eventType)) {

            // 创建uc 用户

            Boolean result = commonService.ucSynRegister2(userName, password);
            if (!result) {
                result = commonService.ucSynRegister2(userName, password);// 注册失败在尝试一次
            }
            if (!result) {
                throw new ServiceException(MessageErrorCode.SYS_REG_UC_ERROR);
            }
        }

        // 保存
        String ucToken = UcAuthCode.generateToken(userName, password, Constant.UC_TOKEN_KEY, "");

        // 生成salt
        String salt = String.valueOf(System.currentTimeMillis());
        String pwdHash = MD5Utils.encode(password, salt);

        Update update = new Update();
        update.set("userName", userName);
        update.set("pwdHash", pwdHash);
        update.set("modifyTime", new Date());
        update.set("ucToken", ucToken);
        update.set("salt",salt);
        mongoTemplate.updateFirst(new BasicQuery("{_id:'" + userModel.getId() + "}'"), update, UserModel.class);
    }


    /**
     * 第三方注册 微信
     *
     * @param wxUserInfo
     */
    @EventListener
    public void thirdByWechat(WxUserInfo wxUserInfo) throws IOException {
        String nickname = wxUserInfo.getNickname();
        String avatar = wxUserInfo.getHeadimgurl();
        String openId = wxUserInfo.getUnionid();
        String sex = wxUserInfo.getSexZhCn();
        registerToUc(openId, sex, avatar, nickname, "wxUser");
    }

    /**
     * 第三方注册 QQ
     *
     * @param qqUser
     */
    @EventListener
    public void thirdByWechat(User qqUser) throws IOException {
        String nickname = qqUser.getNickname();
        String avatar = StringUtils.isBlank(qqUser.getFigureUrlQQ2()) ? qqUser.getFigureUrlQQ1() : qqUser.getFigureUrlQQ2();
        String openId = qqUser.getOpenid();
        String sex = qqUser.getGender().text();
        registerToUc(openId, sex, avatar, nickname, "qqUser");
    }


    /**
     * 向ucenter  注册用户
     *
     * @param openId
     * @param sex
     * @param avatar
     * @param nickname
     * @param type
     */
    private void registerToUc(String openId, String sex, String avatar, String nickname, String type) throws IOException {
        UserModel userModel = new UserModel();

        if (StringUtils.isNotBlank(avatar)) {
            //  下载文件保存文件到本地
            String[] filePaths = commonService.downloadImg(avatar, Constant.UPLOAD_MODEL_IMG_HEAD);
            userModel.setAvatar(filePaths[0]);
        }
        // 生成密码
        String newPwd = StringUtil.RandomIntString(6); //6位的随机密码
        // 生成salt
        String salt = String.valueOf(System.currentTimeMillis());


        userModel.setWechatOpenId(openId);
        userModel.setSex(sex);
        userModel.setCreateTime(new Date());
        userModel.setSalt(salt);
        userModel.setPwdHash(MD5Utils.encode(newPwd, salt));
        userModel.setState(Constant.STATE_ENABLE);
        userModel.setAvatar(avatar);

        // 同步注册discuz
        String newUserName = commonService.generateAndRegisterUcCode(nickname, newPwd, type, 5);

        userModel.setUcToken(UcAuthCode.generateToken(newUserName, newPwd, Constant.UC_TOKEN_KEY, ""));// 设置token
        userModel.setUserName(newUserName);
        userModel.setPwdHash(MD5Utils.encode(newPwd, salt));

        mongoTemplate.save(userModel);  // 保存

        logger.info(type + ">--openid" + openId + "\tusername" + newUserName + " \tpwd:" + newPwd);

    }

}
