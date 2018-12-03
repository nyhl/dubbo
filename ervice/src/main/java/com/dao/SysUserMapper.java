package com.dao;


import org.springframework.stereotype.Repository;
import pojo.SysRole;
import pojo.SysUser;

import java.util.List;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    List<SysUser> getUser();

    SysUser findByUsername(String userName);

    List<SysRole> findRoleByUsername(String userName);

}