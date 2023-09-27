package com.jmye.spring6.first;

import com.jmye.spring6.first.beans.HelloWorld;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/27 01:10
 * @Version 1.0
 */
public class HelloWorldTest {
    private Logger logger = LoggerFactory.getLogger(HelloWorldTest.class);

    @Test
    public void testHelloWorld() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
        HelloWorld helloworld = (HelloWorld) ac.getBean("helloWorld");
        helloworld.sayHello();
        logger.info("执行成功...");
    }

}
