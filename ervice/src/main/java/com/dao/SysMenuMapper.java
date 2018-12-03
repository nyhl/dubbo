package com.dao;


import org.springframework.stereotype.Repository;
import pojo.SysMenu;

import java.util.List;
import java.util.Set;

@Repository
public interface SysMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    Set<String> findPermissionByUserId(String userId);
    List<SysMenu> getTreeList();
}