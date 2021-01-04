package com.example.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product implements Serializable {
    private Integer productId;
    private String productName;
    private String productIcon;
    private String productDesc;
    private BigDecimal price;
    private Integer categoryId;
    private Integer isSale;
    private Integer stock;
    private Date createTime;
    private Date updateTime;
}
