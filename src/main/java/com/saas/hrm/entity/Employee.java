package com.saas.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 17:10
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    private Integer id;

    private String username;

    private String mobile;

    private Date timeOfEntry;

    private String departmentName;

    private Integer sex;

    private Date dateOfBirth;

    private String education;

    private String qq;

    private String wechat;

    private String email;

    private String domicile;

    private String idNumber;

    private String city;

    private String bankCardNumber;
}
