package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.annotation.KthLog;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @KthLog("这是切面日志。。。")
    @RequestMapping("user/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        //log.info("info request id:" + id);
        return userService.findUserById(id);
    }
}