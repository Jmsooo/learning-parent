package com.jmye.cloud.service;

import com.jmye.cloud.bean.Depart;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/5 19:10
 * @Version 1.0
 */
public interface DepartService {
    boolean saveDepart(Depart depart);

    boolean removeDepartById(int id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listAllDeparts();
}
