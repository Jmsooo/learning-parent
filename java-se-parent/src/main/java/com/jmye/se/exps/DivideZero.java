package com.jmye.se.exps;

/**
 * @Description
 * @Author jmye
 * @Time 2023/12/5 22:54
 * @Version 1.0
 */
public class DivideZero {
    int x;
    public static void main(String[] args) {
        int y;
        DivideZero divideZero = new DivideZero();
        y = 3/divideZero.x;
        System.out.println("program ends ok!");
    }
}
