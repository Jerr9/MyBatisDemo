package com.example.mybatis.controller;

import com.example.mybatis.bean.Result;
import com.example.mybatis.service.ProductService;
import com.example.mybatis.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("product")
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("list")
    public Result getCategoryList() {
        log.info("----- {}", productService.getCategoryList());
        return ResultUtil.success();
    }
}
