package com.example.demo2.service.impl;

import com.example.demo2.entity.User;
import com.example.demo2.mapper.UserMapper;
import com.example.demo2.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUser(String username){
        return userMapper.selectByUsername(username);
    }
}
