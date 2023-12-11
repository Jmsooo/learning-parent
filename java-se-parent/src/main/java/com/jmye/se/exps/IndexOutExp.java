package com.jmye.se.exps;

/**
 * @Description
 * @Author jmye
 * @Time 2023/12/5 22:49
 * @Version 1.0
 */
public class IndexOutExp {
    public static void main(String[] args) {
        String friends[] = {"lisa","bily","kessy"};
        for (int i = 0; i < 5; i++) {
            System.out.println("friend = " + friends[i]);
        }
        System.out.println("\n this is the end!");
    }
}
