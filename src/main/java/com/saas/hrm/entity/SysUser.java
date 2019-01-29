package com.saas.hrm.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:30
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mobile;

    private String username;

    private String password;

    private Integer enableState;

    private Date createTime;

}
