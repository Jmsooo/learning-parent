package com.jmye.spring6.first;

import com.jmye.spring6.first.beans.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/27 01:10
 * @Version 1.0
 */
public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
        HelloWorld helloworld = (HelloWorld) ac.getBean("helloWorld");
        helloworld.sayHello();
    }

}
