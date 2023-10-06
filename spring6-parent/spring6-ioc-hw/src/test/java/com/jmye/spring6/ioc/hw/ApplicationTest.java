package com.jmye.spring6.ioc.hw;

import com.jmye.spring6.ioc.hw.core.AnnotationApplicationContext;
import com.jmye.spring6.ioc.hw.core.ApplicationContext;
import com.jmye.spring6.ioc.hw.service.UserService;
import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/1 00:18
 * @Version 1.0
 */
public class ApplicationTest {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationApplicationContext("com.jmye.spring6.ioc.hw");
        UserService userService = (UserService) context.getBean(UserService.class);
        userService.out();
        System.out.println("run success!");
    }

}
