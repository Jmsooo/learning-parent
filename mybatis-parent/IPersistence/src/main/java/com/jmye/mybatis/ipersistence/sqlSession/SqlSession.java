package com.jmye.mybatis.ipersistence.sqlSession;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/11 00:09
 * @Version 1.0
 */
public interface SqlSession {
    // 查询所有
    public <T> List<T> selectList(String statementId, Object... params);

    // 根据条件查询单个
    public <T> T selectOne(String statementId, Object... params);
}
