package com.saas.hrm.controller;

import com.saas.hrm.dto.SysPermissionDTO;
import com.saas.hrm.entity.SysPermission;
import com.saas.hrm.entity.SysRole;
import com.saas.hrm.response.Result;
import com.saas.hrm.response.ResultEnum;
import com.saas.hrm.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 10:57
 * @Description:
 */
@RestController
@RequestMapping("/sys/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @PostMapping
    public Result save(@RequestBody SysPermissionDTO sysPermissionDTO) {
        int save= sysPermissionService.save
                (sysPermissionDTO.getName(),sysPermissionDTO.getCode(),sysPermissionDTO.getType(),
                        sysPermissionDTO.getDescription());
        if (save > 0) {
            return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
        }
        return new Result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMessage(),null);
    }

    @GetMapping
    public Result<SysRole> findAll() {
        List<SysPermission> sysUserList =  sysPermissionService.findAll();
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),sysUserList);
    }

}
