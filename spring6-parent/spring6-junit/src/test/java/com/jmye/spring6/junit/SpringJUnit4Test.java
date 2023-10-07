package com.jmye.spring6.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 22:03
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringJUnit4Test {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }
}
