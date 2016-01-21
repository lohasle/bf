package org.lohas.bf.services.base;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.apache.commons.lang.time.DateUtils;
import org.lohas.bf.constant.Constant;
import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.dao.common.SYS_GLOBAL;
import org.lohas.bf.pojo.MessageErrorCode;
import org.lohas.bf.spring.SpringMessageSourceAccessor;
import org.lohas.bf.utils.JwtUtil;
import org.lohas.bf.utils.ucenterapi.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fule on 14-5-30.
 */

/**
 * 基础服务  用于查找系统配置 用户信息 消息读取
 */
public class BasicServiceImpl implements BasicService {


    private Logger logger = LoggerFactory.getLogger(BasicServiceImpl.class);


    //uClient 客户端
    public static Client uClient = null;

    static {
        String appUrl = SYS_GLOBAL.getConfig("dz.ucApi");
        String appKey = SYS_GLOBAL.getConfig("dz.ucKey");
        String appId = SYS_GLOBAL.getConfig("dz.ucAppId");
        uClient = Client.getInstance(appUrl, "", appKey, appId, "");
    }


    @Autowired
    private SpringMessageSourceAccessor springMessageSourceAccessor;


    /**
     * 得到消息
     *
     * @param msgId
     * @param args
     * @return
     */
    @Override
    public String getMessage(String msgId, Object... args) {
        return springMessageSourceAccessor.getMessage(msgId, args);
    }

    /**
     * 创建一个 jwt token
     *
     * @param uid
     * @param uName
     * @param avatar
     * @param avs    api 版本 可以为null
     * @param issuer 发起者ip
     * @return
     */
    @Override
    public String createToken(String uid, String uName, String avatar, String avs, String issuer) {

        Integer exp = Integer.parseInt(SYS_GLOBAL.getConfig("jwt.exp"));
        String key = SYS_GLOBAL.getConfig("jwt.secret");
        return createToken(uid, uName, avatar, avs, issuer, key, exp);

    }

    /**
     * @param uid
     * @param uName
     * @param avatar
     * @param avs
     * @param issuer
     * @param key    key
     * @param exp    过期时间 分为单位
     * @return
     */
    @Override
    public String createToken(String uid, String uName, String avatar, String avs, String issuer, String key, Integer exp) {
        try {
            JwtUtil.TokenBody tokenBody = new JwtUtil.TokenBody();
            tokenBody.setAvatar(avatar);
            tokenBody.setIssuer(issuer);
            tokenBody.setUid(uid);
            tokenBody.setUname(uName);
            tokenBody.setExp(DateUtils.addHours(new Date(), exp));
            tokenBody.setAvs(avs);
            String token = JwtUtil.createToken(new JwtUtil.TokenHead(),tokenBody, key);
            return token;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.error("create jwt token error");
            throw new ServiceException(MessageErrorCode.JWT_CREATE_ERROR);
        }
    }


    /**
     * uc同步注册
     *
     * @param userName 用户名
     * @param pwd      明文密码
     */
    public Map<String, Object> uc_syn_register(String userName, String pwd) {
        //同步注册 同时赠送邮箱
        String emName = PinyinHelper.convertToPinyinString(userName, "", PinyinFormat.WITHOUT_TONE);
        emName = emName.length() > 20 ? emName.substring(0, 20) : emName;
        String errmsg = "";
        Map resultMap = new HashMap();
        try {
            emName = emName.toLowerCase().replaceAll("_", "");
            String $returns = uClient.uc_user_register(userName, pwd, emName + Constant.EMAIL_SUFFIX);
            int $uid = Integer.parseInt($returns);
            if ($uid <= 0) {
                if ($uid == -1) {
                    errmsg = "用户名不合法";
                } else if ($uid == -2) {
                    errmsg = "用户名包含要不允许注册的词语";
                } else if ($uid == -3) {
                    errmsg = "用户名已经存在";
                } else if ($uid == -4) {
                    errmsg = "Email格式有误";
                } else if ($uid == -5) {
                    errmsg = "Email不允许注册";
                } else if ($uid == -6) {
                    errmsg = "Email 已经被注册";
                } else {
                    errmsg = "ucenter 未定义";
                }
                logger.warn(userName + "--->" + errmsg);
                resultMap.put("errmsg", errmsg);
            }
            logger.info("reg uc discuz user {} - {} - {}",new String[]{String.valueOf($uid),userName,pwd});
            resultMap.put("code", $uid);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(errmsg);
        }
    }
}
