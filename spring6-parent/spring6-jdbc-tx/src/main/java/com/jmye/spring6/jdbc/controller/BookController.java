package com.jmye.spring6.jdbc.controller;

import com.jmye.spring6.jdbc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 22:59
 * @Version 1.0
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }
}
