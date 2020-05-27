package com.tom.persistence.dao.impl;

import com.tom.persistence.common.AbstractHibernateDao;
import com.tom.persistence.dao.IParentDao;
import com.tom.persistence.model.Parent;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParentDao extends AbstractHibernateDao<Parent> implements IParentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ParentDao() {
        super();

        setClazz(Parent.class);
    }

    // API

}
