package com.tom.persistence.service.impl;

import com.tom.persistence.common.AbstractService;
import com.tom.persistence.common.IOperations;
import com.tom.persistence.dao.IFooDao;
import com.tom.persistence.model.Foo;
import com.tom.persistence.service.IFooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooService extends AbstractService<Foo> implements IFooService {

    @Autowired
    private IFooDao dao;

    public FooService() {
        super();
    }

    // API

    @Override
    protected IOperations<Foo> getDao() {
        return dao;
    }

}
