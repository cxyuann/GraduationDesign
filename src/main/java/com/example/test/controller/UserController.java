package com.example.test.controller;

import com.example.test.po.User;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("message","欢迎来到异世界！异世相遇，尽享美味！");
        return "index";
    }
    @RequestMapping("/tologin")
    public String toLogin(){
        return "newlogin";
    }
    @RequestMapping("/tologin1")
    public String toLogin1(){
        return "login";
    }
    @RequestMapping("/userlogin")
    public String login(@RequestParam(value = "username")String username
            ,@RequestParam(value = "password")String password){
        username = request.getParameter("username");
        password = request.getParameter("password");
        User user= userService.login(username,password);
        System.err.println(user);
        if(user == null) {
            session.removeAttribute("user");
            return "login";
        }
        session = request.getSession();
        session.setAttribute("user", user);
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model,@RequestParam(value = "username")String username
            ,@RequestParam(value = "password")String password){
        userService.Register(username,password);
        return "index";
    }
}
