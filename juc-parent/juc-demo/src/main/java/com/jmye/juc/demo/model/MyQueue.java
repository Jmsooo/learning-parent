package com.jmye.juc.demo.model;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 21:05
 * @Version 1.0
 */
public class MyQueue {

    // 下一条 存储记录 的下标
    private int putIndex = 0;
    // 下一条 获取元素 的下标
    private int getPutIndex = 0;

    // 存储数据数组
    private String[] data = new String[10];
    // data 数据中的元素个数
    private int size = 0;

    public synchronized void put(String element) {
        if (size == data.length) {
            try {
                // 阻塞, 等待
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        data[putIndex] = element;
        // 唤醒等待的消费者, 消费数据
        notify();
        ++size;
        ++putIndex;
        if (putIndex == data.length) {
            putIndex = 0;
        }
    }

    public synchronized String get() {
        if (size == 0) {
            try {
                // 阻塞, 等待
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String result = data[getPutIndex];
        --size;
        ++getPutIndex;
        if (getPutIndex == data.length) {
            getPutIndex = 0;
        }

        // 唤醒生产者生产数据, 因为锁是当前对象, this
        notify();
        return result;
    }

}
