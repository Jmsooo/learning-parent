package com.jmye.spring6.aop.service.impl;

import com.jmye.spring6.aop.service.Calculator;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/6 17:32
 * @Version 1.0
 */
@Service
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {

        int result = i + j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result = i * j;

        System.out.println("方法内部 result = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;

        System.out.println("方法内部 result = " + result);

        return result;
    }
}
