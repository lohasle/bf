package org.lohas.bf.services.base;

/**
 * Created by fule on 14-5-30.
 */

/**
 * 基础服务  用于查找系统配置 用户信息 等
 */
public interface BasicService {

    /**
     * 得到消息
     *
     * @param args
     * @return
     */
    String getMessage(String msgId, Object... args);


    /**
     * 创建一个 jwt token
     * @param uid
     * @param uName
     * @param avatar
     * @param avs api 版本 可以为null
     * @param issuer 发起者ip
     * @return
     */
    String createToken(String uid,String uName,String avatar,String avs,String issuer);

    /**
     *
     * @param uid
     * @param uName
     * @param avatar
     * @param avs
     * @param issuer
     * @param key  key
     * @param exp  过期时间 分为单位
     * @return
     */
    String createToken(String uid,String uName,String avatar,String avs,String issuer,String key,Integer exp);


}
