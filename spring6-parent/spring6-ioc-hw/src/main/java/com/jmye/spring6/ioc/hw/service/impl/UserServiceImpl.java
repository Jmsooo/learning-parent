package com.jmye.spring6.ioc.hw.service.impl;

import com.jmye.spring6.ioc.hw.annotations.Bean;
import com.jmye.spring6.ioc.hw.annotations.Di;
import com.jmye.spring6.ioc.hw.dao.UserDao;
import com.jmye.spring6.ioc.hw.service.UserService;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/30 22:43
 * @Version 1.0
 */
@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;
    @Override
    public void out() {
        userDao.print();
        System.out.println("Service 层执行结束...");
    }
}
