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
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    public List<ProductCategoryDTO> getCategoryList() {
        log.info("=========== {}", productMapper.getCategoryList());
        List<ProductCategory> list = productMapper.getCategoryList();
        List<ProductCategoryDTO> pcDTOList = new ArrayList<>();
        CopyPropertyUtil.copyPropertiesIgnoreNull(list, pcDTOList);
        log.info("------pcDTOList------- {}", pcDTOList);
        for(ProductCategoryDTO category : pcDTOList) {

            List<Product> productList = productMapper.getProductByCategoryId(category.getCategoryId());
            log.info("------------- {}", productList);
            List<ProductDTO> dtoList = new ArrayList<>();
            ProductDTO pDto = new ProductDTO();
            for(Product product : productList) {
                CopyPropertyUtil.copyPropertiesIgnoreNull(product, pDto);
                dtoList.add(pDto);
            }
            category.setChildren(dtoList);
        }
        log.info("=========== {}", pcDTOList);
        return null;
    }

    public ProductDTO getDetailById(Integer id) {
        Product detail = productMapper.getDetailById(id);
        ProductDTO dto = new ProductDTO();
        CopyPropertyUtil.copyPropertiesIgnoreNull(detail, dto);
        return dto;
    }
}
