package com.jmye.juc.demo.model;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 21:42
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        MyQueue2 myQueue2 = new MyQueue2();

        for (int i = 0; i < 5; i++) {
            new ProducerThread(myQueue2).start();
            new ConsumerThread(myQueue2).start();
        }
    }
}
