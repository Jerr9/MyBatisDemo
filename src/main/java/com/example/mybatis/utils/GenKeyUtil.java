package com.example.mybatis.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
public class GenKeyUtil {
    public static String genUniqueStringKey() {
        return UUID.randomUUID().toString();
    }

    /**
     *
     * @return 输出28位数字组成的字符串
     */
    public static String genUniqueIntKey() {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String localDate = LocalDateTime.now().format(ofPattern);
        StringBuilder b = new StringBuilder(localDate);
        for(int i = 0; i <= 10; i++) {
            b.append((int)(Math.random() * 9 + 1));
        }
        return b.toString();
    }
}
