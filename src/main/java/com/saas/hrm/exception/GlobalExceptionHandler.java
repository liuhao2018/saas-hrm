package com.saas.hrm.exception;

import com.saas.hrm.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 10:13
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public Result handleException(CustomException ce) {
        return new Result(ce.getCode(),ce.getMessage(),null);
    }
}
