package com.example.mybatis.mapper;

import com.example.mybatis.entity.Product;
import com.example.mybatis.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
//    @Select("select category_id as categoryId from tb_product_category")
    List<ProductCategory> getCategoryList();

    @Select("select category_id as categoryId, " +
            "product_id as productId, " +
            "product_name as productName, " +
            "price, " +
            "product_description as productDesc, " +
            "is_sale as isSale, " +
            "stock, " +
            "product_icon as productIcon " +
            "from tb_product where product_id = #{id, jdbcType=INTEGER}")
    Product getDetailById(Integer id);

//    @Select("select category_id as categoryId, " +
//            "product_id as productId, " +
//            "product_name as productName, " +
//            "price, " +
//            "product_description as productDesc, " +
//            "is_sale as isSale, " +
//            "stock, " +
//            "product_icon as productIcon " +
//            "from tb_product where product_id in (#{ids, jdbcType=VARCHAR})")
    List<Product> getDetailByIds(@Param("ids") List<String> ids);

    @Select("select category_id as categoryId, " +
            "product_id as productId, " +
            "product_name as productName, " +
            "price, " +
            "product_description as productDesc, " +
            "is_sale as isSale, " +
            "stock, " +
            "product_icon as productIcon " +
            "from tb_product where category_id = #{id, jdbcType=INTEGER}")
    List<Product> getProductByCategoryId(@Param("id") Integer id);
}
