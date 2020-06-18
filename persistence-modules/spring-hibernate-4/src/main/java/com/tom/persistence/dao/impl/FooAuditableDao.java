package com.tom.persistence.dao.impl;

import com.tom.persistence.dao.IFooAuditableDao;
import com.tom.persistence.dao.common.AbstractHibernateAuditableDao;
import com.tom.persistence.model.Foo;

public class FooAuditableDao extends AbstractHibernateAuditableDao<Foo> implements IFooAuditableDao {

    public FooAuditableDao() {
        super();

        setClazz(Foo.class);
    }

    // API

}
