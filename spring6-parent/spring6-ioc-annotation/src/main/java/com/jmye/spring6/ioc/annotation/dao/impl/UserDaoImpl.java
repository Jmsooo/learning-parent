package com.jmye.spring6.ioc.annotation.dao.impl;

import com.jmye.spring6.ioc.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/29 16:49
 * @Version 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void print() {
        System.out.println("Dao 层执行结束...");
    }
}
