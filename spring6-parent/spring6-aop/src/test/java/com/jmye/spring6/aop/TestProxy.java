package com.jmye.spring6.aop;

import com.jmye.spring6.aop.service.Calculator;
import com.jmye.spring6.aop.service.impl.CalculatorImpl;
import com.jmye.spring6.aop.proxy.ProxyFactory;
import org.junit.jupiter.api.Test;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 13:46
 * @Version 1.0
 */
public class TestProxy {
    @Test
    public void testDynamicProxy() {
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.add(1, 2);
        // proxy.div(1,1);
    }
}
