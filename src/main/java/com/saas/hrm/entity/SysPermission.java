package com.saas.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:41
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer type;

    private String code;

    private String description;
}
