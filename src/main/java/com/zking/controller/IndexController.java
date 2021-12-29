package com.zking.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequiresPermissions("用户管理")
    @RequestMapping("/update")
    public String updateUser(){
        return "admin/updateUser";
    }


}
