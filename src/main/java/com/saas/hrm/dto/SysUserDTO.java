package com.saas.hrm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 10:27
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserDTO {
    private String username;
    private String mobile;
    private String password;
}
