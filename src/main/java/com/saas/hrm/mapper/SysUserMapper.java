package com.saas.hrm.mapper;


import com.saas.hrm.entity.SysRole;
import com.saas.hrm.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: liuhao
 * @Date: 2019/1/29 09:43
 * @Description:
 */
@org.apache.ibatis.annotations.Mapper
public interface SysUserMapper extends Mapper<SysUser> {

    @Insert("INSERT INTO sys_user_role VALUES (#{userId},#{roleId})")
    int bindRole(@Param("userId")Integer userId,@Param("roleId")Integer roleId);

    @Select("SELECT * FROM sys_role WHERE id IN (SELECT role_id FROM sys_user_role WHERE user_id = #{userId})")
    List<SysRole> findRoleByUserId(Integer userId);

}
