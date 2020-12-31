package com.example.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductCategory implements Serializable {
    private Integer categoryId;
    private String categoryName;
    private String categoryDesc;
    private String categoryIcon;
    private Date createTime;
    private Date updateTime;
}
