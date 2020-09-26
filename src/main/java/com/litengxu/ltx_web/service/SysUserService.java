package com.litengxu.ltx_web.service;

import com.litengxu.ltx_web.entity.SysUser;
import org.springframework.stereotype.Service;

@Service
public interface SysUserService {

     SysUser selectByAccount(String account);

     /**
      * 修改数据
      *
      * @param sysUser 实例对象
      * @return 实例对象
      */
     SysUser update(SysUser sysUser);
     /**
      * 通过ID查询单条数据
      *
      * @param id 主键
      * @return 实例对象
      */
     SysUser queryById(Integer id);
}
