package com.example.mybatis.service;

import com.example.mybatis.entity.User;

import java.util.Map;

public interface UserService {
    User getUserByUid(String uid);

    int addUser(User user);

    int userRegistry(User user);

    int updateUser(User user);

    int updateUserMap(Map map);

    int deleteUser(String id);
}
