package com.tom.persistence.service.impl;

import com.tom.persistence.dao.IBarDao;
import com.tom.persistence.dao.common.IOperations;
import com.tom.persistence.model.Bar;
import com.tom.persistence.service.IBarService;
import com.tom.persistence.service.common.AbstractHibernateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BarService extends AbstractHibernateService<Bar> implements IBarService {

    @Autowired
    @Qualifier("barHibernateDao")
    private IBarDao dao;

    public BarService() {
        super();
    }

    // API

    @Override
    protected IOperations<Bar> getDao() {
        return dao;
    }

}
