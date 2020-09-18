package com.example.demo2.controller;
import com.example.demo2.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected UserService userService;

    @Autowired
    protected LoginService loginService;
}
