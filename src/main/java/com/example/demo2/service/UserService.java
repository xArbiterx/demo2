package com.example.demo2.service;

import com.example.demo2.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    /**
     * 保存用户
     * @param username username
     * @return user
     */
    User saveUser (String username);

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    User getUser (long userId);
}
