package com.jmye.se.exps;

/**
 * @Description
 * @Author jmye
 * @Time 2023/12/5 22:52
 * @Version 1.0
 */
public class NullRef {
    int anInt = 1;
    public static void main(String[] args) {
        NullRef nullRef = new NullRef();
        nullRef = null;
        System.out.println("nullRef.anInt = " + nullRef.anInt);
    }
}
