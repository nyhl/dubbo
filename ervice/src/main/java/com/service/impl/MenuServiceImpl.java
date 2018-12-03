package com.service.impl;


import com.dao.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.SysMenu;
import service.MenuService;


import java.util.List;
import java.util.Set;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public Set<String> findPermissionByUserId(String userId) {
        return sysMenuMapper.findPermissionByUserId(userId);
    }

    @Override
    public List<SysMenu> getTreeList() {
        return sysMenuMapper.getTreeList();
    }
}
