package com.tom.persistence.service.impl;

import com.tom.persistence.dao.IBarCrudRepository;
import com.tom.persistence.model.Bar;
import com.tom.persistence.service.IBarService;
import com.tom.persistence.service.common.AbstractSpringDataJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public class BarSpringDataJpaService extends AbstractSpringDataJpaService<Bar> implements IBarService {

    @Autowired
    private IBarCrudRepository dao;

    public BarSpringDataJpaService() {
        super();
    }

    @Override
    protected CrudRepository<Bar, Serializable> getDao() {
        return dao;
    }

}
