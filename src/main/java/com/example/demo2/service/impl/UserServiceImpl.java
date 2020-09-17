package com.example.demo2.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo2.entity.User;
import com.example.demo2.mapper.UserMapper;
import com.example.demo2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User saveUser(String username) {
        User user = new User();
        user.setId(IdWorker.getId());
        user.setUsername(username);
        userMapper.insert(user);
        return user;
    }

    @Override
    public User getUser(long userId) {
        User user = userMapper.selectById(userId);
        return user;
    }
}
