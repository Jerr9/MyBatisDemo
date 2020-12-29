package com.example.mybatis.bean;

import lombok.Data;

@Data
public class ResBody<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResBody(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
