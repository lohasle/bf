package org.lohas.bf.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by lohas on 2015/9/12.
 * https://github.com/lohasle
 * 用于国际化 消息读取
 */
@Component
public class SpringMessageSourceAccessor implements MessageSourceAware {


    /**
     * Spring 消息读取
     */
    private MessageSourceAccessor message;

    /**
     * Set the MessageSource that this object runs in.
     * <p>Invoked after population of normal bean properties but before an init
     * callback like InitializingBean's afterPropertiesSet or a custom init-method.
     * Invoked before ApplicationContextAware's setApplicationContext.
     *
     * @param messageSource message sourceto be used by this object
     */
    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.message = new MessageSourceAccessor(messageSource, Locale.SIMPLIFIED_CHINESE);
    }

    public MessageSourceAccessor getMessageSourceAccessor(){
        return message;
    }

    public String getMessage(String msgId, Object... args){
        return message.getMessage(msgId,args);
    }

    public String getMessage(String msgId){
        return message.getMessage(msgId);
    }
}
