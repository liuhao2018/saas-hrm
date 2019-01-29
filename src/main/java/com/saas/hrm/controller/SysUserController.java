package com.saas.hrm.controller;

import com.saas.hrm.dto.SysUserDTO;
import com.saas.hrm.dto.SysUserRoleDTO;
import com.saas.hrm.entity.SysPermission;
import com.saas.hrm.entity.SysRole;
import com.saas.hrm.entity.SysUser;
import com.saas.hrm.response.Result;
import com.saas.hrm.response.ResultEnum;
import com.saas.hrm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 10:08
 * @Description:
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public Result login(@RequestBody SysUserDTO sysUserDTO) {
        String jws = sysUserService.login(sysUserDTO);
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),jws);
    }

    @PostMapping
    public Result save(@RequestBody SysUserDTO sysUserDTO) {
        int save= sysUserService.save
                (sysUserDTO.getMobile(),sysUserDTO.getUsername(),sysUserDTO.getPassword());
        if (save > 0) {
            return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
        }
        return new Result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMessage(),null);
    }

    @GetMapping
    public Result<SysUser> findAll() {
        List<SysUser> sysUserList =  sysUserService.findAll();
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),sysUserList);
    }

    @PostMapping("/role")
    public Result bindRole(@RequestBody SysUserRoleDTO sysUserRoleDTO) {
        int bind = sysUserService.bindRole(sysUserRoleDTO.getUserId(),sysUserRoleDTO.getRoleId());
        if (bind > 0) {
            return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),null);
        }
        return new Result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMessage(),null);
    }

    @GetMapping("/{userId}/role")
    public Result findRoleByUser(@PathVariable("userId")Integer userId) {
        List<SysRole> sysRoleList = sysUserService.findRoleByUserId(userId);
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),sysRoleList);
    }

    @GetMapping("/{userId}/permission")
    public Result findPermissionByUser(@PathVariable("userId")Integer userId) {
        List<SysPermission> sysPermissionList = sysUserService.findPermissionByUserId(userId);
        return new Result(ResultEnum.OK.getCode(),ResultEnum.OK.getMessage(),sysPermissionList);
    }
}
