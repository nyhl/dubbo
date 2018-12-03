package com.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.SysUser;
import service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private UserService userService;
        /**
         * 验证登录
         * @param user
         * @param model
         * @param session
         * @return url
         */
        @RequestMapping(value = "/login")
        @ResponseBody
        public Map<String,Object> Login(SysUser user, HttpServletResponse response, HttpSession session, Model model){
             Map<String,Object> map=new HashMap<>();
            if(user.getLogin_name()==null){
               map.put("message", "账号不为空");
               map.put("code",1);
            }

            //主体,当前状态为没有认证的状态“未认证”
            Subject subject = SecurityUtils.getSubject();
            // 登录后存放进shiro token
            UsernamePasswordToken token=new UsernamePasswordToken(user.getLogin_name(),user.getPassword());
            SysUser user1;
            //登录方法（认证是否通过）
            //使用subject调用securityManager,安全管理器调用Realm
            try {
                //利用异常操作
                //需要开始调用到Realm中
                System.out.println("========================================");
                System.out.println("1、进入认证方法");
                subject.login(token);
                user1 = (SysUser)subject.getPrincipal();
                session.setAttribute("user1",subject);
                map.put("message", "登录完成");
                map.put("code",0);
            } catch (UnknownAccountException e) {
                map.put("message", "账号密码不正确");
                map.put("code",1);
            }


            return map;
        }




}
