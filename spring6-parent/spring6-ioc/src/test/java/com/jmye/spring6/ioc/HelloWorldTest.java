package com.jmye.spring6.ioc;

import com.jmye.spring6.ioc.beans.HelloWorld;
import com.jmye.spring6.ioc.beans.Student;
import com.jmye.spring6.ioc.beans.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/27 22:47
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

    @Test
    public void testHelloWorld1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
        HelloWorld helloWorld = ac.getBean(HelloWorld.class);
        helloWorld.sayHello();
        logger.info("执行成功...");
    }

    @Test
    public void testHelloWorld2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
        HelloWorld helloWorld = ac.getBean("helloWorld", HelloWorld.class);
        helloWorld.sayHello();
        logger.info("执行成功...");
    }

    @Test
    public void testDIBySet() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentOne", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void testDIByConstructor() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-di.xml");
        Student studentOne = ac.getBean("studentTwo", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void testBeanScope() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-scope.xml");
        User user1 = ac.getBean(User.class);
        User user2 = ac.getBean(User.class);
        System.out.println(user1 == user2);
    }

    @Test
    public void testLife() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ac.getBean(User.class);
        System.out.println("生命周期: 4.通过IOC容器获取bean并使用");
        ac.close();
    }

    @Test
    public void testUserFactoryBean(){
        //获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-factorybean.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }

}
