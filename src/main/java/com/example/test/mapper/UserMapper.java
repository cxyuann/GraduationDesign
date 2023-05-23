package com.example.test.mapper;

import com.example.test.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectUserByUsernamePassword(String username, String password);

    void Register(String username,String password);
}
