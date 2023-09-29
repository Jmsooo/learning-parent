package com.jmye.spring6.ioc.annotation;

import com.jmye.spring6.ioc.annotation.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/29 16:54
 * @Version 1.0
 */
public class UserTest {

    @Test
    public void testAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.out();
    }

}
