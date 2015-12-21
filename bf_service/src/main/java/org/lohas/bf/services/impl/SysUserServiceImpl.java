package org.lohas.bf.services.impl;

import org.apache.commons.lang.StringUtils;
import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.dao.common.PageBeanParams;
import org.lohas.bf.dao.entities.SysUser;
import org.lohas.bf.dao.entities.SysUserExample;
import org.lohas.bf.dao.mapper.SysUserMapper;
import org.lohas.bf.pojo.PageBean;
import org.lohas.bf.services.SysUserService;
import org.lohas.bf.services.base.BasicServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fule https:github.com/lohasle on 2015/12/11 0011.
 * 后台管理员服务
 */
@Service
@Transactional
public class SysUserServiceImpl extends BasicServiceImpl implements SysUserService {


    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);


    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 后台管理员分页数据
     *
     * @param pageNo
     * @param pageSize
     * @param order
     * @return
     */
    @Override
    public PageBean<SysUser> qrySysUserPage(int pageNo, int pageSize, String order, SysUser sysUser) {
        PageBeanParams pageBeanParams = PageBeanParams.getPageBeanParams(pageNo, pageSize);
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();//查询条件

        if (sysUser != null && StringUtils.isNotBlank(sysUser.getUserName())) {
            criteria.andUserNameLike("%" + sysUser.getUserName() + "%");
        }

        //count
        int count = sysUserMapper.countByExample(sysUserExample);

        //list
        sysUserExample.setLimitStart(pageBeanParams.getLimitStart());
        sysUserExample.setLimitEnd(pageBeanParams.getLimitEnd());
        order = StringUtils.isBlank(order) ? " create_time desc" : order;
        sysUserExample.setOrderByClause(order);
        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

        return PageBean.buildPageBean(list, Long.valueOf(count), pageNo, pageSize);
    }

    /**
     * 查询一个人员
     *
     * @param id
     * @return
     */
    @Override
    public SysUser findSysUserById(int id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 创建
     *
     * @param sysUser
     * @return
     */
    @Override
    public Boolean addSysUser(SysUser sysUser) {
        try {
            int result = sysUserMapper.insertSelective(sysUser);
            return result>0;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new ServiceException();
        }
    }

    /**
     * 更新
     *
     * @param sysUser
     * @return
     */
    @Override
    public Boolean updateSysUser(SysUser sysUser) {
        try {
            int result = sysUserMapper.updateByPrimaryKey(sysUser);
            return result>0;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new ServiceException();
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public Boolean delSysUserById(int id) {
        try {
            int result = sysUserMapper.deleteByPrimaryKey(id);
            return result>0;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new ServiceException();
        }
    }
}
