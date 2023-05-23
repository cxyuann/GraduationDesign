package com.example.test.controller;

import com.example.test.po.User;
import com.example.test.service.UserService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("message","你是谁？");
        return "/index.jsp";
    }
    @GetMapping("/login")
    public String login(Model model,@RequestParam(value = "username")String username
            ,@RequestParam(value = "password")String password){
        User user= userService.login(username,password);
        if (user==null){
            model.addAttribute("message","登录失败");
        }else {
            model.addAttribute("message","登录成功");
        }
        return "/index.jsp";
    }

    @GetMapping("/register")
    public String register(Model model,@RequestParam(value = "username")String username
            ,@RequestParam(value = "password")String password){
        userService.Register(username,password);
        return "/index.jsp";
    }
}
