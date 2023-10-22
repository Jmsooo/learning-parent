package com.jmye.juc.demo.thread;

import java.util.concurrent.Callable;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 17:25
 * @Version 1.0
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "hello world call() invoked!";
    }
}
