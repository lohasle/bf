package org.lohas.bf.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lohas on 2015/9/12.
 * https://github.com/lohasle
 */
@Component
public class SpringWebContent  {

    private Logger logger = LoggerFactory.getLogger(SpringWebContent.class);

    /**
     *  清空Session 防止Session序列化后 重启系统 仍可以登录等操作
     */
    @PreDestroy
    public void destroy(){
        HttpServletRequest request = WebUtils.getHttpServletRequest();
        if(request!=null){
            logger.warn("clean all http sessions");
            request.getSession().invalidate();
        }
    }
}
