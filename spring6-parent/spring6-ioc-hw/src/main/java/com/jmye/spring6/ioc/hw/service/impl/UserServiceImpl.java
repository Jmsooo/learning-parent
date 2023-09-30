package com.jmye.spring6.ioc.hw.service.impl;

import com.jmye.spring6.ioc.hw.service.UserService;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/30 22:43
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void out() {
        System.out.println("Service 层执行结束...");
    }
}
