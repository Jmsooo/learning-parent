package com.jmye.spring6.ioc.annotation.service.impl;

import com.jmye.spring6.ioc.annotation.dao.UserDao;
import com.jmye.spring6.ioc.annotation.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/29 16:50
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void out() {
        userDao.print();
        System.out.println("Service 层执行结束...");
    }
}
