package com.jmye.juc.demo.model;

import java.util.Random;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 21:03
 * @Version 1.0
 */
public class ConsumerThread extends Thread {
    private final MyQueue myQueue;
    private final Random random = new Random();

    public ConsumerThread(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String result = myQueue.get();
            System.out.println("\t\t消费者: " + Thread.currentThread().getName() + " 消费数据 " + result);
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
