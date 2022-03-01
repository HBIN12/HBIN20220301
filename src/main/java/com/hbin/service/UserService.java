package com.hbin.service;

import com.hbin.entity.User;

import java.util.List;


public interface UserService {
    boolean login(User user);
    int mkdirs();
}
