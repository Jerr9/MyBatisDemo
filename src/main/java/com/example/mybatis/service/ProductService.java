package com.example.mybatis.service;

import com.example.mybatis.dto.ProductCategoryDTO;

import java.util.List;

public interface ProductService {
    List<ProductCategoryDTO> getCategoryList();
}
