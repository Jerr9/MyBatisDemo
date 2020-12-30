package com.example.mybatis.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
class GenKeyUtilTest {

    @Test
    void genUniqueStringKey() {

    }

    @Test
    void genUniqueIntKey() {
        log.info("============== {}", GenKeyUtil.genUniqueIntKey());
        log.info("============== {}", GenKeyUtil.genUniqueStringKey());
    }
}