package com.tom.persistence.dao.impl;

import com.tom.persistence.dao.IBarAuditableDao;
import com.tom.persistence.dao.common.AbstractHibernateAuditableDao;
import com.tom.persistence.model.Bar;

import java.util.List;

public class BarAuditableDao extends AbstractHibernateAuditableDao<Bar> implements IBarAuditableDao {

    public BarAuditableDao() {
        super();

        setClazz(Bar.class);
    }

    // API

    @Override
    public List<Bar> getRevisions() {
        final List<Bar> resultList = super.getRevisions();
        for (final Bar bar : resultList) {
            bar.getFooSet().size(); // force FooSet initialization
        }
        return resultList;
    }

}