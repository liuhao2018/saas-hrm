package com.saas.hrm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 14:21
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRoleDTO {

    private Integer userId;
    private Integer roleId;

}
