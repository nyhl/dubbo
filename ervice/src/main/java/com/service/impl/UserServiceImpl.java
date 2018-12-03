package com.service.impl;

import com.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.SysRole;
import pojo.SysUser;
import service.UserService;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public List<SysUser> getUser() {

       return sysUserMapper.getUser();

    }

    @Override
    public SysUser findByUsername(String userName) {
        return sysUserMapper.findByUsername(userName);
    }

    @Override
    public SysRole findRoleByUsername(String userName) {
        return null;
    }

    @Override
    public void addUser(SysUser user) {
        user.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        user.setCreate_date(new Date());
        sysUserMapper.insert(user);
    }
}