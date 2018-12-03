package com.service.impl;

import com.dao.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RoleService;


import java.util.Set;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
     private SysRoleMapper sysRoleMapper;
    @Override
    public Set<String> findRoleByUserId(String userId) {
        return sysRoleMapper.findRoleByUserId(userId);
    }
}
