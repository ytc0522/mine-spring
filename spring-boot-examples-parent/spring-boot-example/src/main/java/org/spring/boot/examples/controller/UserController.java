package org.spring.boot.examples.controller;

import org.spring.boot.examples.entities.UserEntity;
import org.spring.boot.examples.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者 xinyi
 * 日期 2022/5/7
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;


    @GetMapping("/get")
    public UserEntity getUser() {
        return userService.getUser();
    }

}
