package com.example.mybatis.service;

import com.example.mybatis.dto.ProductCategoryDTO;
import com.example.mybatis.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductCategoryDTO> getCategoryList();

    ProductDTO getDetailById(Integer id);

    List<ProductDTO> getDetailById(String ids);
}
