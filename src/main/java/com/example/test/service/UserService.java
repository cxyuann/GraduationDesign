package com.example.test.service;

import com.example.test.po.User;

public interface UserService {
    User login(String username, String password);

    void Register(String username, String password);

}
