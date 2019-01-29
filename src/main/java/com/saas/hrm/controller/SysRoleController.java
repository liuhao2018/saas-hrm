package com.saas.hrm.controller;

import com.saas.hrm.dto.SysRoleDTO;
import com.saas.hrm.dto.SysRolePermissionDTO;
import com.saas.hrm.dto.SysUserRoleDTO;
import com.saas.hrm.entity.SysPermission;
import com.saas.hrm.entity.SysRole;
import com.saas.hrm.response.Result;
import com.saas.hrm.response.ResultEnum;
import com.saas.hrm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 10:54
 * @Description:
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping
    public Result save(@RequestBody SysRoleDTO sysRoleDTO) {
        int save= sysRoleService.save
                (sysRoleDTO.getName(),sysRoleDTO.getDescription());
        if (save > 0) {
            return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
        }
        return new Result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMessage(),null);
    }

    @GetMapping
    public Result<SysRole> findAll() {
        List<SysRole> sysUserList =  sysRoleService.findAll();
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),sysUserList);
    }

    @PostMapping("/permission")
    public Result bindRole(@RequestBody SysRolePermissionDTO sysRolePermissionDTO) {
        int bind = sysRoleService.bindPermission(sysRolePermissionDTO.getRoleId(),sysRolePermissionDTO.getPermissionId());
        if (bind > 0) {
            return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
        }
        return new Result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMessage(),null);
    }

    @GetMapping("/{roleId}/permission")
    public Result findRoleByUser(@PathVariable("roleId")Integer roleId) {
        List<SysPermission> sysPermissionList = sysRoleService.findPermissionByRoleId(roleId);
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),sysPermissionList);
    }

}
