package com.example.mybatis.mapper;


import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;

import java.util.Map;

public interface UserMapper {
    User getUserByUid(String uid);

    @Insert("insert into tb_user(name, age, sex, uid) values(" +
            "#{username, jdbcType=VARCHAR}," +
            "#{age, jdbcType=INTEGER}," +
            "#{sex, jdbcType=INTEGER}," +
            "#{uid, jdbcType=VARCHAR}" +
            ")")
    int addUser(User user);

    int userRegistry(User user);

    int updateUser(User user);

    int updateUserMap(Map map);

    int deleteUser(String id);
}
