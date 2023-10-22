package com.jmye.juc.demo.model;

import java.util.Random;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 21:05
 * @Version 1.0
 */
public class ProducerThread extends Thread {
    private final MyQueue myQueue;
    private final Random random = new Random();
    private int index = 0;

    public ProducerThread(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String temp = "element-" + index;
            myQueue.put(temp);
            System.out.println("生产者: " + Thread.currentThread().getName() + " 生产数据 " + temp);
            index++;
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
