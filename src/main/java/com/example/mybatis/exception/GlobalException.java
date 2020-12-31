package com.example.mybatis.exception;

import com.example.mybatis.enums.ResEnum;

public class GlobalException extends RuntimeException {
    public GlobalException(ResEnum resEnum) {
        super(resEnum.getMsg());
    }
}
