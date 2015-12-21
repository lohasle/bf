package org.lohas.bf.services.base;

import org.lohas.bf.dao.common.SYS_GLOBAL;
import org.lohas.bf.spring.SpringMessageSourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Created by fule on 14-5-30.
 */

/**
 * 基础服务  用于查找系统配置 用户信息 消息读取
 */
public class BasicServiceImpl implements BasicService {


    private Logger logger = LoggerFactory.getLogger(BasicServiceImpl.class);

    @Autowired
    private SpringMessageSourceAccessor springMessageSourceAccessor;

    /**
     *  全局消息 发布类
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    /**
     * 取得消息发布
     * @return
     */
    public ApplicationEventPublisher getApplicationEventPublisher() {
        return applicationEventPublisher;
    }

    /**
     * 得到消息
     *
     * @param msgId
     * @param args
     * @return
     */
    @Override
    public String getMessage(String msgId, Object... args) {
        return springMessageSourceAccessor.getMessage(msgId,args);
    }


}
