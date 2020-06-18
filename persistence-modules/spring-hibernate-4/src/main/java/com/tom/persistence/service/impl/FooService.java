package com.tom.persistence.service.impl;

import com.tom.persistence.dao.IFooDao;
import com.tom.persistence.dao.common.IOperations;
import com.tom.persistence.model.Foo;
import com.tom.persistence.service.IFooService;
import com.tom.persistence.service.common.AbstractHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FooService extends AbstractHibernateService<Foo> implements IFooService {

    @Autowired
    @Qualifier("fooHibernateDao")
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
