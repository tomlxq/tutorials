package com.tom.persistence.dao.impl;

import com.tom.persistence.dao.IFooDao;
import com.tom.persistence.dao.common.AbstractHibernateDao;
import com.tom.persistence.model.Foo;
import org.springframework.stereotype.Repository;

@Repository
public class FooDao extends AbstractHibernateDao<Foo> implements IFooDao {

    public FooDao() {
        super();

        setClazz(Foo.class);
    }

    // API

}
