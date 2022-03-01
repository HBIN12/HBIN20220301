package com.hbin;

import com.hbin.dao.UserMapper;
import com.hbin.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test1 extends test{
    @Autowired
    private UserMapper userMapper;
    private UserService userService;
    @Test
    public void tset12(){
        System.out.println(userMapper.GetAllUser());
        userService.mkdirs();
    }
}
