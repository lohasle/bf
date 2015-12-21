package org.lohas.bf.web.controller.backstage;

import com.alibaba.fastjson.JSONObject;
import org.lohas.bf.dao.common.PageBeanParams;
import org.lohas.bf.dao.entities.LoggingEvent;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.PageBean;
import org.lohas.bf.services.LoggingService;
import org.lohas.bf.web.view.DataTable.DataTables;
import org.lohas.bf.web.view.DataTable.DataTablesReqPar;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lohas on 2015/09/07
 * 日志管理控制器
 */
@Controller
@RequestMapping("/backstage/logging")
public class BackstageLoggingController {
    private Logger logger = LoggerFactory.getLogger(BackstageLoggingController.class);

    @Autowired
    private LoggingService loggingService;



    //列表页面
    @RequestMapping(value = "/list")
    public String showloggingPage(HttpServletRequest request) {
        return "backstage/logging/list";
    }

    //列表页面
    @RequestMapping(value = "/list.json")
    @ResponseBody
    public DataTables showloggingPageJson(HttpServletRequest request, String dataTablesReqPar) throws ParseException {
        DataTablesReqPar tablesReqPar = JSONObject.parseObject(dataTablesReqPar, DataTablesReqPar.class); // 表格参数
        String level = request.getParameter("level");
        String loggerName = request.getParameter("loggerName");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String content = request.getParameter("content");

        Map params = new HashMap();
        params.put("level", level);
        params.put("loggerName", loggerName);
        if(StringUtils.isNotBlank(beginDate)){
            params.put("beginDate", DateUtils.parseDate(beginDate,new String[]{"yyyy-MM-dd HH"}).getTime());
        }
        if(StringUtils.isNotBlank(beginDate)){
            params.put("endDate", DateUtils.parseDate(endDate,new String[]{"yyyy-MM-dd HH"}).getTime());
        }
        params.put("content", content);

        PageBeanParams pageBeanParams = tablesReqPar.getPageBeanParams();
        PageBean pageBean = loggingService.qryLoggingPage(pageBeanParams.getPageNo(), pageBeanParams.getPageSize(), tablesReqPar.getOrderString(), params);
        return DataTables.Create().format(pageBean, tablesReqPar);
    }


    // 日志详情
    @RequestMapping("detail.json")
    @ResponseBody
    public Message loggingDetail(HttpServletRequest request, Integer eventId) {
        LoggingEvent loggingEvent = loggingService.qryOneLogging(eventId);
        return new Message(Message.STATE_TRUE, loggingEvent);
    }
}
