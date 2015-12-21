package org.lohas.bf.services;

import org.lohas.bf.dao.entities.SysUser;
import org.lohas.bf.pojo.PageBean;
import org.lohas.bf.services.base.BasicService;

/**
 * Created by fule https:github.com/lohasle on 2015/12/11 0011.
 */
public interface SysUserService extends BasicService {

    /**
     * 后台管理员分页数据
     *
     * @param pageNo
     * @param pageSize
     * @param order
     * @return
     */
    PageBean<SysUser> qrySysUserPage(int pageNo, int pageSize, String order, SysUser sysUser);


    /**
     * 查询一个人员
     *
     * @param id
     * @return
     */
    SysUser findSysUserById(int id);



    /**
     * 创建
     *
     * @param sysUser
     * @return
     */
    Boolean addSysUser(SysUser sysUser);


    /**
     * 更新
     *
     * @return
     */
    Boolean updateSysUser(SysUser sysUser);


    /**
     * 删除
     *
     * @return
     */
    Boolean delSysUserById(int id);


}
