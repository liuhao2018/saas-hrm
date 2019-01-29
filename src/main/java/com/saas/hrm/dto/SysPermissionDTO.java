package com.saas.hrm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 10:30
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysPermissionDTO {
    private String name;
    private String description;
    private String code;
    private Integer type;
}
