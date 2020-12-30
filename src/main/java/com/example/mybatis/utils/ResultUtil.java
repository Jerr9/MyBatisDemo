package com.example.mybatis.utils;

import com.example.mybatis.bean.Result;
import com.example.mybatis.enums.ResEnum;

public class ResultUtil {
    public static Result success() {
        return new Result(ResEnum.SUCCESS.getCode(), ResEnum.SUCCESS.getMsg(), null);
    }
    public static Result success(ResEnum resEnum) {
        return new Result(resEnum.getCode(), resEnum.getMsg(), null);
    }

    public static Result success(Object data) {
        return new Result(ResEnum.SUCCESS.getCode(), ResEnum.SUCCESS.getMsg(), data);
    }

    public static Result fail() {
        return new Result(ResEnum.NOT_EXIST.getCode(), ResEnum.NOT_EXIST.getMsg(), null);
    }

//    public static Result fail(String msg) {
//        Result r = new Result(ResEnum.UNKNOWN_ERROR);
//        r.setMsg(msg);
//        return r;
//    }

    public static Result fail(ResEnum resEnum) {
        return new Result(resEnum.getCode(), resEnum.getMsg(), null);
    }
}
