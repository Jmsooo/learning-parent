package com.jmye.juc.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 17:29
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                5,
                1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10)) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                // 如果 call() 方法执行过程中存在异常, 此处可以进行处理
                super.afterExecute(r, t);
            }
        };

        Future<String> future = executor.submit(new MyCallable());

        String result = future.get();
        System.out.println("result = " + result);

        executor.shutdown();
    }
}
