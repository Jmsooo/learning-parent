package com.jmye.spring6.ioc.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/28 00:38
 * @Version 1.0
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
