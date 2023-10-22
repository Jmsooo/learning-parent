package com.jmye.juc.demo.model;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 21:05
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        ProducerThread producerThread = new ProducerThread(myQueue);
        ConsumerThread consumerThread = new ConsumerThread(myQueue);

        producerThread.start();
        consumerThread.start();
    }
}
