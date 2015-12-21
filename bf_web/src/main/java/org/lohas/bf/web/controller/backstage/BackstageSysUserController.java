package org.lohas.bf.web.controller.backstage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.lohas.bf.dao.common.PageBeanParams;
import org.lohas.bf.dao.entities.SysUser;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.PageBean;
import org.lohas.bf.services.SysUserService;
import org.lohas.bf.web.view.DataTable.DataTables;
import org.lohas.bf.web.view.DataTable.DataTablesReqPar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lohas on 2015/09/07
 * 管理员用户管理控制器
 */
@Controller
@RequestMapping("/backstage/user")
public class BackstageSysUserController {
    private Logger logger = LoggerFactory.getLogger(BackstageSysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    //列表页面
    @RequestMapping(value = "/list")
    public String showListPage(HttpServletRequest request) {
        return "backstage/sysuser/list";
    }

    //列表数据
    @RequestMapping(value = "/list.json")
    @ResponseBody
    public DataTables getListPageJson(HttpServletRequest request, String dataTablesReqPar, SysUser sysUser) {

       /* for(int i=0;i<10;i++){
            logger.info(JSON.toJSONString(sysUser));  // 测试日志写入
        }*/
        DataTablesReqPar tablesReqPar = JSONObject.parseObject(dataTablesReqPar, DataTablesReqPar.class); // 表格参数
        PageBeanParams pageBeanParams = tablesReqPar.getPageBeanParams();
        PageBean pageBean = sysUserService.qrySysUserPage(pageBeanParams.getPageNo(), pageBeanParams.getPageSize(), tablesReqPar.getOrderString(), sysUser);
        return DataTables.Create().format(pageBean, tablesReqPar);
    }

    //find one
    @RequestMapping(value = "/{sysUserId}")
    @ResponseBody
    public Message<SysUser> getSysUser(@PathVariable int sysUserId) {
        SysUser sysUser = sysUserService.findSysUserById(sysUserId);
        return new Message<>(Message.STATE_TRUE, sysUser);
    }

    //del one
    @RequestMapping(value = "/del")
    @ResponseBody
    public Message delOne(int id) {
        Boolean boo = sysUserService.delSysUserById(id);
        return new Message(boo ? "true" : "false");
    }

    //create one
    @RequestMapping(value = "/add")
    @ResponseBody
    public Message<SysUser> addOne(SysUser sysUser) {
        Boolean boo = sysUserService.addSysUser(sysUser);
        return new Message(boo ? "true" : "false");
    }

    //update one
    @RequestMapping(value = "/update")
    @ResponseBody
    public Message<SysUser> updateOne(SysUser sysUser) {
        Boolean boo = sysUserService.updateSysUser(sysUser);
        return new Message(boo ? "true" : "false");
    }

}
