package com.dao;

import org.springframework.stereotype.Repository;
import pojo.SysRole;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    Set<String> findRoleByUserId(String userId);
}