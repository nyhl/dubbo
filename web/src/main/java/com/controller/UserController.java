package com.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.SysUser;
import service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("getUser")
    @ResponseBody
    public Map<String,Object> getUser(){
        Map<String,Object> map=new HashMap<>();
        List<SysUser> list=new ArrayList<>();
        try{

            list=userService.getUser();
            map.put("code",0);
            map.put("msg","加载成功");
            map.put("count",list.size());
            map.put("data",list);


        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
            map.put("count",list.size());
            map.put("data",list);
        }

        return map;
    }
    @RequestMapping("addUser")
    @ResponseBody
    @Cacheable
    public Map<String,Object> addUser(SysUser user){
        Map<String,Object> map=new HashMap<>();
        try{
            userService.addUser(user);
            map.put("code",0);
            map.put("msg","操作成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
            map.put("msg","操作失败");
        }
        return map;
    }
}
