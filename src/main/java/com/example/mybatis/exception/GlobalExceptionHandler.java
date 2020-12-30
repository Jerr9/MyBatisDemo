package com.example.mybatis.exception;

import com.example.mybatis.bean.Result;
import com.example.mybatis.enums.ResEnum;
import com.example.mybatis.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = )
    @ResponseBody
    @ExceptionHandler(value = {MissingPathVariableException.class, MissingServletRequestParameterException.class})
    public Result webExceptionHandler(Exception e) {
        log.info("=============================================================== {}", e.getMessage());
        Result r = ResultUtil.fail(ResEnum.UNKNOWN_ERROR);
        r.setDebugMsg(e.getMessage());
        return r;
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        Result r = ResultUtil.fail(ResEnum.UNKNOWN_ERROR);
        r.setDebugMsg(e.getMessage());
        return r;
    }
}
