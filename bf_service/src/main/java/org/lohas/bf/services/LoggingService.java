package org.lohas.bf.services;

import org.lohas.bf.dao.entities.LoggingEvent;
import org.lohas.bf.pojo.PageBean;
import org.lohas.bf.services.base.BasicService;

import java.util.Map;

/**
 * Created by lohas on 2015/9/7.
 * https://github.com/lohasle
 * 日志系统
 */
public interface LoggingService extends BasicService {

    /**
     * 日志列表
     * @param map
     * @return
     */
    PageBean<LoggingEvent> qryLoggingPage(int pageNo, int pageSize, String order, Map map);

    /**
     * 日志详情
     * @param eventId
     * @return
     */
    LoggingEvent qryOneLogging(int eventId);
}
