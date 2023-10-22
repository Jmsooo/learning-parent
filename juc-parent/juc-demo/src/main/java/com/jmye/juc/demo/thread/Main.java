package com.jmye.juc.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 15:01
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new MyThread().start();
        // new Thread(new MyRunnable()).start();

        MyCallable myCallable = new MyCallable();

        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();

        // 同步等待线程执行的结果
        String result = futureTask.get();
        System.out.println("result = " + result);
    }
}
