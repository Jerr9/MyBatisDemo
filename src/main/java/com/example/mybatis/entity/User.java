package com.example.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private int roleId;
    private String uid;
    private String name;
    private int age;
    private int sex;
}
