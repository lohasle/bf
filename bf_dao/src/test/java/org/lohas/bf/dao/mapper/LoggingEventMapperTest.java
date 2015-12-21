package org.lohas.bf.dao.mapper;

import com.alibaba.fastjson.JSON;
import org.lohas.bf.dao.common.PageBeanParams;
import org.lohas.bf.dao.entities.LoggingEvent;
import org.lohas.bf.dao.mapper.base.SpringTransactionalTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggingEventMapperTest extends SpringTransactionalTestCase {
    @Autowired
    private LoggingEventMapper mapper;

    @Test
    public void testQryLoggingPage() throws Exception {
        Map map1 = new HashMap<>();
        PageBeanParams pageBeanParams = new PageBeanParams();
        map1.put("level","info");
        map1.put("loggerName","spring");
        pageBeanParams.setLimitStart(0);
        pageBeanParams.setLimitEnd(100);
        pageBeanParams.setOrder("  event_id desc");
        List list = mapper.qryLoggingPage(map1,pageBeanParams);
        System.out.println("------------------------>");
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void testSelectByEventId() throws Exception {
        LoggingEvent loggingEvent = mapper.selectByEventId(8425);
        System.out.println(JSON.toJSONString(loggingEvent));
    }
}