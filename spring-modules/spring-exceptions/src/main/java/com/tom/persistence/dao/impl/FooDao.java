package com.tom.persistence.dao.impl;

import com.tom.persistence.common.AbstractHibernateDao;
import com.tom.persistence.dao.IFooDao;
import com.tom.persistence.model.Foo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FooDao extends AbstractHibernateDao<Foo> implements IFooDao {

    @Autowired
    private SessionFactory sessionFactory;

    public FooDao() {
        super();

        setClazz(Foo.class);
    }

    // API

}
