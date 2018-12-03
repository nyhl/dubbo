package service;




import pojo.SysRole;
import pojo.SysUser;

import java.util.List;

public interface UserService {
     List<SysUser> getUser();
     SysUser findByUsername(String userName);
     SysRole findRoleByUsername(String userName);
     void addUser(SysUser user);

}
