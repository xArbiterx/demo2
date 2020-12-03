package com.example.demo2.service.impl;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserService;
import com.example.demo2.util.SnowflakeIdGenerator;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public User saveUser(String username) {
        User user = User.builder()
                .id(SnowflakeIdGenerator.get().nextId())
                .username(username)
                .password("1")
                .build();
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(long userId) {
        var user = userRepository.findById(userId);
        return user.orElse(null);
    }
}
