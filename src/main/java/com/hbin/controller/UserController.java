package com.hbin.controller;

import com.hbin.entity.User;
import com.hbin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    @ResponseBody
    public User login(User user){
        System.out.println(userService.login(user));
        List<User> users= new ArrayList<>();
        return user;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/redirect")
    public String redirect(){
    return "redirect:http://ariang.js.org/#!/settings/rpc/set/ws/43.154.33.229/6800/jsonrpc/YjJlYWFlNmZhMWIyODA2MTljMDM=";
    }

    @RequestMapping("/mkdirs")
    public String mkdirs(){
        userService.mkdirs();
        return "1";
    }
}