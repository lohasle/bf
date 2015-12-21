package org.lohas.bf.dao.mapper;

import org.lohas.bf.dao.common.PageBeanParams;
import org.lohas.bf.dao.entities.LoggingEvent;
import org.lohas.bf.dao.entities.LoggingEventException;
import org.lohas.bf.dao.entities.LoggingEventProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lohas on 2015/9/7.
 * https://github.com/lohasle
 */
public interface LoggingEventMapper {
    List<LoggingEvent> qryLoggingPage(@Param("params") Map map, @Param("page") PageBeanParams pageBeanParams);

    int countByPage(@Param("params") Map map);

    LoggingEvent selectByEventId(Integer eventId);

    LoggingEventException selectExceptionsByEventId(Integer eventId);

    LoggingEventProperty selectEventPropertyByEventId(Integer eventId);

}
