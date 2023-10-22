package com.jmye.juc.demo.thread;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 14:59
 * @Version 1.0
 */
public class MyThread extends Thread{

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
