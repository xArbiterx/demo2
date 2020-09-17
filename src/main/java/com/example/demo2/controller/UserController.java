package com.example.demo2.controller;

import com.example.demo2.entity.User;
import com.example.demo2.model.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @GetMapping(path = "/{userId}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<UserVO> index(@PathVariable("userId") long userId) {
        UserVO userResult = new UserVO();
        User u = userService.getUser(userId);
        if (u != null) {
            userResult.setUsername(u.getUsername());
        } else {
            log.warn("user not found. id={}", userId);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userResult, HttpStatus.OK);
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestParam String username) {
        userService.saveUser(username);
    }
}
