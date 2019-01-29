package com.saas.hrm.service;

import com.saas.hrm.entity.SysPermission;
import com.saas.hrm.entity.SysRole;
import com.saas.hrm.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:47
 * @Description:
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public int save(String name,String description) {
        SysRole sysRole = new SysRole();
        sysRole.setName(name);
        sysRole.setDescription(description);
        return sysRoleMapper.insertSelective(sysRole);
    }

    public List<SysRole> findAll() {
        return sysRoleMapper.selectAll();
    }

    public int bindPermission(Integer roleId,Integer permissionId) {
        return sysRoleMapper.bindPermission(roleId,permissionId);
    }

    public List<SysPermission> findPermissionByRoleId(Integer roleId) {
        return sysRoleMapper.findPermissionByRoleId(roleId);
    }

}
