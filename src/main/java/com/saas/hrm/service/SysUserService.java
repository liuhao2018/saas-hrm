package com.saas.hrm.service;

import com.saas.hrm.dto.SysUserDTO;
import com.saas.hrm.entity.SysPermission;
import com.saas.hrm.entity.SysRole;
import com.saas.hrm.entity.SysUser;
import com.saas.hrm.exception.CustomException;
import com.saas.hrm.mapper.SysUserMapper;
import com.saas.hrm.response.ResultEnum;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:51
 * @Description:
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleService sysRoleService;

    public String login(SysUserDTO sysUserDTO) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(sysUserDTO.getUsername());
        sysUser = sysUserMapper.selectOne(sysUser);
        if (sysUser == null) {
            throw new CustomException(ResultEnum.USERNAME_NOT_FOUND.getCode(),
                    ResultEnum.USERNAME_NOT_FOUND.getMessage());
        }
        String password = sysUser.getPassword();
        if (!sysUserDTO.getPassword().equals(password)) {
            throw new CustomException(ResultEnum.PASSWORD_ERROR.getCode(),
                    ResultEnum.PASSWORD_ERROR.getMessage());
        }
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Map<String,Object> map = new HashMap<>();
        List<String> menu = new ArrayList<>();
        List<String> point = new ArrayList<>();
        List<String> api = new ArrayList<>();
        List<SysPermission> sysPermissionList = findPermissionByUserId(sysUser.getId());
        for (SysPermission sysPermission:sysPermissionList) {
            Integer type = sysPermission.getType();
            switch (type) {
                case 0:
                    menu.add(sysPermission.getCode());
                    break;
                case 1:
                    point.add(sysPermission.getCode());
                    break;
                case 2:
                    api.add(sysPermission.getCode());
                    break;
            }
        }
        map.put("menu",menu);
        map.put("point",point);
        map.put("api",api);
        String jws = Jwts
                .builder()
                .setSubject(sysUserDTO.getUsername())
                .setClaims(map)
                .signWith(key).compact();
        return jws;
    }

    public int save(String mobile,String username,String password) {
        SysUser sysUser = new SysUser();
        sysUser.setMobile(mobile);
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        sysUser.setCreateTime(new Date());
        sysUser.setEnableState(1);
        return sysUserMapper.insertSelective(sysUser);
    }

    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }

    public int bindRole(Integer userId,Integer roleId) {
        return sysUserMapper.bindRole(userId,roleId);
    }

    public List<SysRole> findRoleByUserId(Integer userId) {
        return sysUserMapper.findRoleByUserId(userId);
    }

    public List<SysPermission> findPermissionByUserId(Integer userId) {
        List<SysRole> sysRoleList = findRoleByUserId(userId);
        if (sysRoleList == null || sysRoleList.size() == 0) {
            return Arrays.asList();
        }
        List<SysPermission> sysPermissionList = new ArrayList<>();
        for (SysRole sysRole:sysRoleList) {
            Integer roleId = sysRole.getId();
            List<SysPermission> sysPermissions = sysRoleService.findPermissionByRoleId(roleId);
            sysPermissionList.addAll(sysPermissions);
        }
        return sysPermissionList;
    }

}
