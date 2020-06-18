package com.tom.persistence.dao.impl;

import com.tom.persistence.dao.IParentDao;
import com.tom.persistence.dao.common.AbstractHibernateDao;
import com.tom.persistence.model.Parent;
import org.springframework.stereotype.Repository;

@Repository
public class ParentDao extends AbstractHibernateDao<Parent> implements IParentDao {

    public ParentDao() {
        super();

        setClazz(Parent.class);
    }

    // API

}
