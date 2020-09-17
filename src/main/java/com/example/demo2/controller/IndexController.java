package com.example.demo2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class IndexController extends BaseController{

    @GetMapping({"/index", "/"})
    public String index() {

        log.info(request.getRequestURI());
        return request.getRequestURL().toString();
    }


}
