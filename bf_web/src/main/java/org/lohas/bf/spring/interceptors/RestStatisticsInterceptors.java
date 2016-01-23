package org.lohas.bf.spring.interceptors;

import org.lohas.bf.dao.mongomodels.ApiStatisticsModel;
import org.lohas.bf.utils.NetworkUtil;
import org.lohas.bf.utils.ThreadPollExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by fule https:github.com/lohasle on 2016/1/23 0023.
 * 统计拦截器
 */
public class RestStatisticsInterceptors extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(RestStatisticsInterceptors.class);

    /**
     * api 统计
     */
    private NamedThreadLocal<ApiStatisticsModel> threadLocal =
            new NamedThreadLocal<>("ApiStatistics");

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ua = request.getHeader("User-Agent");
        String ip = NetworkUtil.getIpAddress(request);
        String url = request.getRequestURI();
        long beginTime = System.currentTimeMillis();

        // 统计数据
        ApiStatisticsModel apiStatisticsModel = new ApiStatisticsModel();
        apiStatisticsModel.setCreateTime(new Date());
        apiStatisticsModel.setRepTime(beginTime);
        apiStatisticsModel.setUa(ua);
        apiStatisticsModel.setIp(ip);
        apiStatisticsModel.setUrl(url);
        threadLocal.set(apiStatisticsModel);

        return super.preHandle(request, response, handler);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        final ApiStatisticsModel apiStatisticsModel = threadLocal.get();
        long beginTime = apiStatisticsModel.getRepTime();
        long endTime = System.currentTimeMillis();
        long consumeTime = endTime - beginTime;//消耗的时间

        apiStatisticsModel.setRepTime(consumeTime);
        ThreadPollExecutor.exeThread(new Runnable() {
            @Override
            public void run() {
                mongoTemplate.save(apiStatisticsModel);// 保存
            }
        });

        super.afterCompletion(request, response, handler, ex);
    }

}
