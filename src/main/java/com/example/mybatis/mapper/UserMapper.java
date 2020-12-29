package com.example.mybatis.mapper;


import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;

import java.util.Map;

public interface UserMapper {
    User getUserById(Integer id);

    @Insert("insert into tb_user(name, age, sex) values(" +
            "#{name, jdbcType=VARCHAR}," +
            "#{age, jdbcType=INTEGER}," +
            "#{sex, jdbcType=INTEGER}" +
            ")")
    int addUser(User user);

    int userRegistry(User user);

    int updateUser(User user);

    int updateUserMap(Map map);

    int deleteUser(Integer id);
}
