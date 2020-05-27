package com.tom.persistence.dao.impl;

import com.tom.persistence.common.AbstractHibernateDao;
import com.tom.persistence.dao.IChildDao;
import com.tom.persistence.model.Child;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChildDao extends AbstractHibernateDao<Child> implements IChildDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ChildDao() {
        super();

        setClazz(Child.class);
    }

    // API

}
