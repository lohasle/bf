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


}
