package com.example.mybatis.enums;

import lombok.Getter;

@Getter
public enum ResEnum {
    SUCCESS(0, "操作成功"),
    UNKNOWN_ERROR(505, "系统异常"),
    NOT_EXIST(1, "操作对象不存在"),

    USER_NOT_EXIST(1000, "用户不存在");

    private Integer code;
    private String msg;

    ResEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
