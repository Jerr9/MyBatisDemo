package com.example.mybatis.mapper;

import com.example.mybatis.entity.Product;
import com.example.mybatis.entity.ProductCategory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
//    @Select("select category_id as categoryId from tb_product_category")
    List<ProductCategory> getCategoryList();

    @Select("select category_id as categoryId, " +
            "category_name as categoryName, " +
            "category_icon as categoryIcon, " +
            "category_description as categoryDesc " +
            "from tb_product where category_id = #{id, jdbcType=INTEGER}")
    Product getDetailById(Integer id);

    @Select("select category_id as categoryId, " +
            "category_name as categoryName, " +
            "category_icon as categoryIcon, " +
            "category_description as categoryDesc " +
            "from tb_product where category_id = #{id, jdbcType=INTEGER}")
    Product getProductByIds(String ids);

    @Select("select category_id as categoryId, " +
            "category_name as categoryName, " +
            "category_icon as categoryIcon, " +
            "category_description as categoryDesc " +
            "from tb_product where category_id = #{id, jdbcType=INTEGER}")
    List<Product> getProductByCategoryId(Integer id);
}
