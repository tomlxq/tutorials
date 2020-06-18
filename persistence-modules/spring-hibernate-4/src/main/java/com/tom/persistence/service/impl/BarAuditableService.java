package com.tom.persistence.service.impl;

import com.tom.persistence.dao.IBarAuditableDao;
import com.tom.persistence.dao.IBarDao;
import com.tom.persistence.dao.common.IAuditOperations;
import com.tom.persistence.dao.common.IOperations;
import com.tom.persistence.model.Bar;
import com.tom.persistence.service.IBarAuditableService;
import com.tom.persistence.service.common.AbstractHibernateAuditableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BarAuditableService extends AbstractHibernateAuditableService<Bar> implements IBarAuditableService {

    @Autowired
    @Qualifier("barHibernateDao")
    private IBarDao dao;

    @Autowired
    @Qualifier("barHibernateAuditableDao")
    private IBarAuditableDao auditDao;

    public BarAuditableService() {
        super();
    }

    // API

    @Override
    protected IOperations<Bar> getDao() {
        return dao;
    }

    @Override
    protected IAuditOperations<Bar> getAuditableDao() {
        return auditDao;
    }

}
