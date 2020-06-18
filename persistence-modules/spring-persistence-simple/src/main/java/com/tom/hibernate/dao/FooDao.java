package com.tom.hibernate.dao;

import com.tom.jpa.dao.IFooDao;
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
