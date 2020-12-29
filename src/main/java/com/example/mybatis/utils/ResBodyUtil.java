package com.example.mybatis.utils;

import com.example.mybatis.bean.ResBody;
import com.example.mybatis.enums.ResEnum;

public class ResBodyUtil {
    public static ResBody success() {
        return new ResBody(ResEnum.SUCCESS.getCode(), ResEnum.SUCCESS.getMsg(), null);
    }
    public static ResBody success(ResEnum resEnum) {
        return new ResBody(resEnum.getCode(), resEnum.getMsg(), null);
    }

    public static ResBody success(Object data) {
        return new ResBody(ResEnum.SUCCESS.getCode(), ResEnum.SUCCESS.getMsg(), data);
    }

    public static ResBody fail() {
        return new ResBody(ResEnum.NOT_EXIST.getCode(), ResEnum.NOT_EXIST.getMsg(), null);
    }

    public static ResBody fail(ResEnum resEnum) {
        return new ResBody(resEnum.getCode(), resEnum.getMsg(), null);
    }
}
