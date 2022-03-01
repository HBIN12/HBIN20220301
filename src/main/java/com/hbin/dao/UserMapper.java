package com.hbin.dao;

import com.hbin.entity.User;

import java.util.List;

public interface UserMapper {
    User SelectUserById(String id);
    List<User> GetAllUser();
}
