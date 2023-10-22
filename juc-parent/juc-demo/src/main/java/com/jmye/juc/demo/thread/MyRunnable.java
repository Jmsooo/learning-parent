package com.jmye.juc.demo.thread;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 15:03
 * @Version 1.0
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + " 运行了...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
