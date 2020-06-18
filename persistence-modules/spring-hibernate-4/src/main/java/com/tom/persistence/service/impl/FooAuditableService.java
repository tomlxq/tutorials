package com.tom.persistence.service.impl;

import com.tom.persistence.dao.IFooAuditableDao;
import com.tom.persistence.dao.IFooDao;
import com.tom.persistence.dao.common.IAuditOperations;
import com.tom.persistence.dao.common.IOperations;
import com.tom.persistence.model.Foo;
import com.tom.persistence.service.IFooAuditableService;
import com.tom.persistence.service.common.AbstractHibernateAuditableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FooAuditableService extends AbstractHibernateAuditableService<Foo> implements IFooAuditableService {

    @Autowired
    @Qualifier("fooHibernateDao")
    private IFooDao dao;

    @Autowired
    @Qualifier("fooHibernateAuditableDao")
    private IFooAuditableDao auditDao;

    public FooAuditableService() {
        super();
    }

    // API

    @Override
    protected IOperations<Foo> getDao() {
        return dao;
    }

    @Override
    protected IAuditOperations<Foo> getAuditableDao() {
        return auditDao;
    }

}
