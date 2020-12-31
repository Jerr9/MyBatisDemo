package com.example.mybatis.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ProductCategoryDTO implements Serializable {
    private Integer categoryId;
    private String categoryName;
    private String categoryDesc;
    private String categoryIcon;
    private Date createTime;
    private Date updateTime;
    private List<ProductDTO> children;
}
