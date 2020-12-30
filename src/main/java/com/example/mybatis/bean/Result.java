package com.example.mybatis.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private String debugMsg;
    private T data;

    public Result() {}

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
