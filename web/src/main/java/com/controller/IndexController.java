package com.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MenuService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private MenuService menuService;
    //加载当前用户的菜单权限
    @RequestMapping("/menu/index")
    @ResponseBody
    public Map<String,Object> index(){
        System.out.println("sdfas");
        Map<String,Object> map=new HashMap<>();
       map.put("data",menuService.getTreeList());

        return map;
    }
}
