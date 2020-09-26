package com.litengxu.ltx_web.service.serviceimpl;

import com.litengxu.ltx_web.entity.SysUser;
import com.litengxu.ltx_web.dao.UserDao;
import com.litengxu.ltx_web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.userDao.queryById(id);
//        return null;
    }

    @Override
    public SysUser selectByAccount(String account) {
        return this.userDao.selectByAccount(account);
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.userDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }
}
