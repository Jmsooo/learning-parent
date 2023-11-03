package com.jmye.mockito.service;

import com.jmye.mockito.dao.DemoDao;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/2 21:44
 * @Version 1.0
 */
public class DemoService {
    private DemoDao demoDao;

    public DemoService(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    public int getDemoStatus() {
        return demoDao.getDemoStatus();
    }

}
