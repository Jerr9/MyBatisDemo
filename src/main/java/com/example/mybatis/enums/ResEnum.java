package com.example.mybatis.enums;

import lombok.Getter;

@Getter
public enum ResEnum {
    SUCCESS(0, "SUCCESS"),
    NOT_EXIST(1, "NOT_EXIST");

    private Integer code;
    private String msg;

    ResEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
