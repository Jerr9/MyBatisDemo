package com.example.mybatis.service.impl;

import com.example.mybatis.dto.ProductCategoryDTO;
import com.example.mybatis.dto.ProductDTO;
import com.example.mybatis.entity.Product;
import com.example.mybatis.entity.ProductCategory;
import com.example.mybatis.mapper.ProductMapper;
import com.example.mybatis.service.ProductService;
import com.example.mybatis.utils.CopyPropertyUtil;
import com.example.mybatis.vo.ProductCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    public List<ProductCategoryDTO> getCategoryList() {
        List<ProductCategory> list = productMapper.getCategoryList();
        List<ProductCategoryDTO> productCategoryDTOList = new ArrayList<>();
        for(ProductCategory category : list) {
            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
            CopyPropertyUtil.copyPropertiesIgnoreNull(category, categoryDTO);
            List<Product> productList = productMapper.getProductByCategoryId(category.getCategoryId());
            categoryDTO.setChildren(productList);
            productCategoryDTOList.add(categoryDTO);
        }
        return productCategoryDTOList;
    }

    public ProductDTO getDetailById(Integer id) {
        Product detail = productMapper.getDetailById(id);
        ProductDTO dto = new ProductDTO();
        CopyPropertyUtil.copyPropertiesIgnoreNull(detail, dto);
        return dto;
    }

    public List<ProductDTO> getDetailById(String ids) {
        List<ProductDTO> result = new ArrayList<>();
        List<String> _ids = Arrays.asList(ids.split(","));
//        int[] _ids =
        List<Product> productList = productMapper.getDetailByIds(_ids);
        log.info("xxxx {} {}", ids, productList);
        for(Product product : productList) {
            ProductDTO dto = new ProductDTO();
            CopyPropertyUtil.copyPropertiesIgnoreNull(product, dto);
            result.add(dto);
        }
        return result;
    }
}
