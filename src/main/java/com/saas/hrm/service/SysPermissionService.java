package com.saas.hrm.service;

import com.saas.hrm.entity.SysPermission;
import com.saas.hrm.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:58
 * @Description:
 */
@Service
public class SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    public int save(String name,String code,Integer type,String description) {
        SysPermission sysPermission = new SysPermission();
        sysPermission.setName(name);
        sysPermission.setCode(code);
        sysPermission.setType(type);
        sysPermission.setDescription(description);
        return sysPermissionMapper.insertSelective(sysPermission);
    }

    public List<SysPermission> findAll() {
        return sysPermissionMapper.selectAll();
    }

}
