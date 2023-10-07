package com.jmye.spring6.aop;

import com.jmye.spring6.aop.proxy.ProxyFactory;
import com.jmye.spring6.aop.service.Calculator;
import com.jmye.spring6.aop.service.impl.CalculatorImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 13:46
 * @Version 1.0
 */
public class TestProxy {

    private Logger logger = LoggerFactory.getLogger(TestProxy.class);

    @Test
    public void testDynamicProxy() {
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.add(1, 2);
        // proxy.div(1,1);
    }

    @Test
    public void testAdd(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Calculator calculator = ac.getBean( Calculator.class);
        int add = calculator.add(1, 1);
        logger.info("执行成功:"+add);
    }
}
