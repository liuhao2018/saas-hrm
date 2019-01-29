package com.saas.hrm.mapper;


import com.saas.hrm.entity.SysPermission;
import com.saas.hrm.entity.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:44
 * @Description:
 */
@org.apache.ibatis.annotations.Mapper
public interface SysRoleMapper extends Mapper<SysRole> {

    @Insert("INSERT INTO sys_role_permission VALUES (#{roleId},#{permissionId})")
    int bindPermission(@Param("roleId")Integer roleId, @Param("permissionId")Integer permissionId);

    @Select("SELECT * FROM sys_permission WHERE id IN (SELECT permission_id FROM sys_role_permission WHERE role_id = #{roleId})")
    List<SysPermission> findPermissionByRoleId(Integer roleId);

}
