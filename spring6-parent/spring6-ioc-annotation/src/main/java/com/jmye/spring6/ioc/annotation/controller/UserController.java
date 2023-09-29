package com.jmye.spring6.ioc.annotation.controller;

import com.jmye.spring6.ioc.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/29 16:52
 * @Version 1.0
 */
@Controller
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    public void out(){
        userService.out();
        System.out.println("Controller 层执行结束...");
    }

}
