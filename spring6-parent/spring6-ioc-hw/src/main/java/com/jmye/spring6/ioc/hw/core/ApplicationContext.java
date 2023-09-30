package com.jmye.spring6.ioc.hw.core;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/30 23:56
 * @Version 1.0
 */
public interface ApplicationContext {
    Object getBean(Class clazz);
}
