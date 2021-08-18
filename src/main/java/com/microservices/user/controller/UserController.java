package com.microservices.user.controller;

import com.microservices.user.VO.RestTemplateVO;
import com.microservices.user.entity.User;
import com.microservices.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public RestTemplateVO getUserwithDepartment(@PathVariable("id") Long userId)
    {
        log.info("Inside getUserwithDepartment of UserController");
        return userService.getUserwithDepartment(userId);
    }
}
