package com.example.test.service.impl;

import com.example.test.mapper.UserMapper;
import com.example.test.po.User;
import com.example.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user=userMapper.selectUserByUsernamePassword(username,password);
        return user;
    }

    @Override
    public void Register(String username, String password) {
        userMapper.Register(username,password);
    }
}
