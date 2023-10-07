package com.jmye.spring6.junit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 21:59
 * @Version 1.0
 */
// 两种方式均可
// 方式一
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:beans.xml")
// 方式二
@SpringJUnitConfig(locations = "classpath:spring-config.xml")
public class SpringJUnit5Test {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }
}