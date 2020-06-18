package com.tom.persistence.dao.impl;

import com.tom.persistence.dao.IChildDao;
import com.tom.persistence.dao.common.AbstractHibernateDao;
import com.tom.persistence.model.Child;
import org.springframework.stereotype.Repository;

@Repository
public class ChildDao extends AbstractHibernateDao<Child> implements IChildDao {

    public ChildDao() {
        super();

        setClazz(Child.class);
    }

    // API

}
