package com.jmye.cloud.service.impl;

import com.jmye.cloud.bean.Depart;
import com.jmye.cloud.repository.DepartRepository;
import com.jmye.cloud.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author jmye
 * @Time 2023/11/5 19:11
 * @Version 1.0
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart saveDepart = repository.save(depart);
        if (saveDepart != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart modifyDepart = repository.save(depart);
        if (modifyDepart != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        if (repository.existsById(id)) {
            return repository.getReferenceById(id);
        }
        return null;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
