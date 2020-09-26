package com.litengxu.ltx_web.controller;

import com.litengxu.ltx_web.common.utils.ResultTool;
import com.litengxu.ltx_web.entity.SysUser;
import com.litengxu.ltx_web.service.SysUserService;
import com.litengxu.ltx_web.service.serviceimpl.SysPermissionServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionServiceimpl sysPermissionService;



    @GetMapping("getUser/{account}")
    @ResponseBody
    public Object findAll(@PathVariable String account){

        System.out.println(account);
        System.out.println(sysUserService.selectByAccount(account));
        return sysUserService.selectByAccount(account);
    }
    @GetMapping("/index")
//    @ResponseBody
    public Object find(){

        return "test";
    }
    @GetMapping("/deleteUser")
    @ResponseBody
    public Object find2(){
        SysUser users = sysUserService.selectByAccount("user1");
        return ResultTool.success(users);
    }
    @GetMapping("/deleteUser/a")
//    @ResponseBody
    public Object find3(){
        SysUser users = sysUserService.selectByAccount("user1");
        return ResultTool.success(users);
    }
    @GetMapping("a/{id}")
    @ResponseBody
    public Object findlist(@PathVariable int  id){
        SysUser sysUser = sysUserService.queryById(id);
        sysUser.setUser_name("用户3");
        return sysUserService.update(sysUser);
    }
}
