package com.jmye.juc.demo.thread;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/30 22:55
 * @Version 1.0
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }

    @Override
    public void run() {
        System.out.println("用 Runnable 方法实线程!");
    }
}
