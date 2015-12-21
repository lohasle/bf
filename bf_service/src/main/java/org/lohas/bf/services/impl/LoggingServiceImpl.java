package org.lohas.bf.services.impl;

import org.lohas.bf.dao.common.PageBeanParams;
import org.lohas.bf.dao.entities.LoggingEvent;
import org.lohas.bf.dao.mapper.LoggingEventMapper;
import org.lohas.bf.pojo.PageBean;
import org.lohas.bf.services.LoggingService;
import org.lohas.bf.services.base.BasicServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lohas on 2015/9/7.
 * https://github.com/lohasle
 */
@Service
public class LoggingServiceImpl extends BasicServiceImpl implements LoggingService {

    private Logger logger = LoggerFactory.getLogger(LoggingServiceImpl.class);

    @Autowired
    private LoggingEventMapper loggingEventMapper;
    /**
     * 日志列表
     *
     * @param map
     * @return
     */
    @Override
    public PageBean<LoggingEvent> qryLoggingPage(int pageNo, int pageSize, String order, Map map) {
        PageBeanParams pageBeanParams =  PageBeanParams.getPageBeanParams(pageNo,pageSize,order);
        List<LoggingEvent> list =  loggingEventMapper.qryLoggingPage(map,pageBeanParams);
        int count = loggingEventMapper.countByPage(map);
        PageBean<LoggingEvent> pageBean = PageBean.buildPageBean(list,Long.valueOf(count),pageNo,pageSize);
        return pageBean;
    }

    /**
     * 日志详情
     *
     * @param eventId
     * @return
     */
    @Override
    public LoggingEvent qryOneLogging(int eventId) {
        return loggingEventMapper.selectByEventId(eventId);
    }
}
