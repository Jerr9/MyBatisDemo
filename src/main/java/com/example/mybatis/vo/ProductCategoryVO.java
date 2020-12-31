package com.example.mybatis.vo;

import com.example.mybatis.entity.Product;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductCategoryVO {
    private String categoryId;
    private String categoryName;
    private String categoryDesc;
    private String categoryIcon;
    private Date createTime;
    private Date updateTime;
    private List<Product> children;
}
