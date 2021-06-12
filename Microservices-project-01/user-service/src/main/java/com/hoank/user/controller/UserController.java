package com.hoank.user.controller;

import com.hoank.user.VO.ResponseTemplateVO;
import com.hoank.user.entity.UserEntity;
import com.hoank.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(userEntity);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
