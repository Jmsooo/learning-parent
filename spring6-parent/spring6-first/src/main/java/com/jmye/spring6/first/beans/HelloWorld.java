package com.jmye.spring6.first.beans;

/**
 * @Description
 * @Author jmye
 * @Time 2023/9/27 01:06
 * @Version 1.0
 */
public class HelloWorld {
    public HelloWorld() {
        System.out.println("无参数构造方法执行...");
    }

    public void sayHello() {
        System.out.println("Say Hello ...");
    }
}
