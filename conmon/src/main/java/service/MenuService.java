package service;


import pojo.SysMenu;

import java.util.List;
import java.util.Set;

public interface MenuService {
    Set<String> findPermissionByUserId(String userId);
    List<SysMenu> getTreeList();
}
