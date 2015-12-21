package org.lohas.bf.spring.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lohas on 2015/6/24.
 * https://github.com/lohasle
 */
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(StopWatchHandlerInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal =
            new NamedThreadLocal<>("StopWatch-StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();
        startTimeThreadLocal.set(beginTime);//线程绑定变量
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long beginTime = startTimeThreadLocal.get();
        long consumeTime = endTime - beginTime;//消耗的时间
        if (consumeTime > 500) {//超过500毫秒的请求记录
            // 记录到日志文件
            logger.info(
                    String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
        }
        super.afterCompletion(request, response, handler, ex);
    }
}
