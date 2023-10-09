package com.jmye.spring6.jdbc.dao;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/7 23:01
 * @Version 1.0
 */
public interface BookDao {
    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateBalance(Integer userId, Integer price);
}
