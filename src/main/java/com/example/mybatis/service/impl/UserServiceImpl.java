package com.example.mybatis.service.impl;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUid(String uid) {
        return userMapper.getUserByUid(uid);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int userRegistry(User user) {
        return userMapper.userRegistry(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserMap(Map map) {
        return userMapper.updateUserMap(map);
    }

    @Override
    public int deleteUser(String uid) {
        return userMapper.deleteUser(uid);
    }
}
