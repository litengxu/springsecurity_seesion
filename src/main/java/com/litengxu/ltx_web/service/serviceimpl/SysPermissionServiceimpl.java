package com.litengxu.ltx_web.service.serviceimpl;

import com.litengxu.ltx_web.entity.SysPermission;
import com.litengxu.ltx_web.dao.PermissionDao;
import com.litengxu.ltx_web.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: ltx_web
 * @ClassName: SysPermissionServiceimpl
 * @Author: 李腾旭
 * @Date: 2020-06-12 15:38
 * @Description: ${todo}
 * @Version: V1.0
 */
@Repository
public class SysPermissionServiceimpl implements SysPermissionService{

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 根据id查出用户权限
     * @param userId
     * @return
     */
    @Override
    public List<SysPermission> selectListByUser(Integer userId) {
        return permissionDao.selectListByUserId(userId);
    }

    @Override
    public List<SysPermission> selectListByPath(String path) {
        return permissionDao.selectListByPath(path);
    }
}
