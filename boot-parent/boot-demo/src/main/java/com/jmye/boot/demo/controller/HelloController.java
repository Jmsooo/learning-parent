package com.jmye.boot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/17 20:24
 * @Version 1.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot!";
    }

}
