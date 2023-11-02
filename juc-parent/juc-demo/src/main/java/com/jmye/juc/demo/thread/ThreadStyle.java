package com.jmye.juc.demo.thread;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/30 23:01
 * @Version 1.0
 */
public class ThreadStyle extends Thread{

    public static void main(String[] args) {
        new ThreadStyle().start();
    }

    @Override
    public void run() {
        System.out.println("用 Thread 方法实线程!");
    }
}
