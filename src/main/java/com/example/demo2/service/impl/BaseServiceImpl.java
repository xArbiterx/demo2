package com.example.demo2.service.impl;

import com.example.demo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务实现基类
 */
public class BaseServiceImpl {
    @Autowired
    protected UserRepository userRepository;
}
