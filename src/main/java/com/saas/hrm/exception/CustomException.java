package com.saas.hrm.exception;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 15:36
 * @Description:
 */
public class CustomException extends RuntimeException {

    private Integer code;
    private String message;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
