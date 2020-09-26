package com.litengxu.ltx_web.config.handler;

import com.alibaba.fastjson.JSON;
import com.litengxu.ltx_web.common.entity.JsonResult;
import com.litengxu.ltx_web.common.utils.ResultTool;
import com.litengxu.ltx_web.entity.SysUser;
import com.litengxu.ltx_web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Program: ltx_web
 * @ClassName: CustomizeAuthenticationSuccessHandler
 * @Author: 李腾旭
 * @Date: 2020-06-13 08:34
 * @Description: 登录成功处理逻辑
 * @Version: V1.0
 *
 *
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Autowired
    SysUserService sysUserService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //更新用户表上次登录时间、更新人、更新时间等字段
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser sysUser = sysUserService.selectByAccount(userDetails.getUsername());
        sysUser.setLast_login_time(new Date());
        sysUser.setUpdate_time(new Date());
        sysUser.setUpdate_user(sysUser.getId());
        sysUserService.update(sysUser);

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

        //返回json数据
        JsonResult result = ResultTool.success();
        //处理编码方式，防止中文乱码的情况
        response.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        response.getWriter().write(JSON.toJSONString(result));

    }
}

