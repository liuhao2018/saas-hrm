package com.saas.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:38
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

}
