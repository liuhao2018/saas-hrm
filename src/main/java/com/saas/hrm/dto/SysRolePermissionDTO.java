package com.saas.hrm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 14:22
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRolePermissionDTO {

    private Integer roleId;
    private Integer permissionId;

}
