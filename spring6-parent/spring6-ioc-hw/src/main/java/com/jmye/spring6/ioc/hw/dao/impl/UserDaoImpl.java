package com.jmye.spring6.ioc.hw.dao.impl;

import com.jmye.spring6.ioc.hw.dao.UserDao;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/30 22:42
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void print() {
        System.out.println("Dao 层执行结束...");
    }
}
