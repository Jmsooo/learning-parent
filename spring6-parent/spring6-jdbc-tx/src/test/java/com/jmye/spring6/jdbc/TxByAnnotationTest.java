package com.jmye.spring6.jdbc;

import com.jmye.spring6.jdbc.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 23:04
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:spring-config.xml")
public class TxByAnnotationTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1, 1);
    }

}