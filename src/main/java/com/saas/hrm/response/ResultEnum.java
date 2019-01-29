package com.saas.hrm.response;


/**
 * @Auther: liuhao
 * @Date: 2019/1/29 10:18
 * @Description:
 */
public enum ResultEnum {

    OK(20000,"成功"),
    FAIL(50000,"失败"),

    USERNAME_NOT_FOUND(50001,"用户名未找到"),
    PASSWORD_ERROR(50002,"密码错误"),
    TOKEN_ERROR(50003,"Token错误"),
    PERMISSION_ERROR(50004,"权限不足");

    private Integer code;
    private String message;

    private ResultEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
