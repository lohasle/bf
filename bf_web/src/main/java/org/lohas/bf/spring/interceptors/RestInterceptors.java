package org.lohas.bf.spring.interceptors;

import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.dao.common.SYS_GLOBAL;
import org.lohas.bf.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fule https:github.com/lohasle on 2016/1/23 0023.
 * rest api 拦截器
 */
public class RestInterceptors extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(RestInterceptors.class);

    final String jwtSecret = SYS_GLOBAL.getConfig("jwt.secret");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");
        try {
            JwtUtil.parseToken(authorization, jwtSecret);
            return super.preHandle(request, response, handler);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            logger.warn("token" + authorization + "\t 非法" );
            throw new ServiceException("非法token");
        }
    }
}

