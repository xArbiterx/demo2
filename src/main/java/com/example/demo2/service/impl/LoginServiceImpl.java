package com.example.demo2.service.impl;

import com.example.demo2.entity.User;
import com.example.demo2.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public User getUser(String username) {
        return new User();
    }
}
