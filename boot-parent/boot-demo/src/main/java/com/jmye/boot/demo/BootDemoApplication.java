package com.jmye.boot.demo;

import com.jmye.boot.demo.test.AbcTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class BootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);

        AbcTest abcTest = new AbcTest();
        System.out.println(abcTest.getName());
    }
}
