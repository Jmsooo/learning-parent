package com.jmye.juc.demo.model;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/22 21:36
 * @Version 1.0
 */
public class MyQueue2 extends MyQueue{
    // 下一条 存储记录 的下标
    private int putIndex = 0;
    // 下一条 获取元素 的下标
    private int getPutIndex = 0;

    // 存储数据数组
    private String[] data = new String[10];
    // data 数据中的元素个数
    private int size = 0;

    @Override
    public synchronized void put(String element) {
        if (size == data.length) {
            try {
                // 阻塞, 等待
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 利用迭代, 进行二次抢占对象锁
            put(element);
        } else {
            put0(element);
        }
    }

    private void put0(String element) {
        data[putIndex] = element;
        // 唤醒等待的消费者, 消费数据
        notify();
        ++size;
        ++putIndex;
        if (putIndex == data.length) {
            putIndex = 0;
        }
    }

    @Override
    public synchronized String get() {
        if (size == 0) {
            try {
                // 阻塞, 等待
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return get();
        }else {
            return get0();
        }
    }

    private String get0() {
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
