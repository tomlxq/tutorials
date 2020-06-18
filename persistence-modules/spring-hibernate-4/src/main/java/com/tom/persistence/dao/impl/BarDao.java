package com.tom.persistence.dao.impl;

import com.tom.persistence.dao.IBarDao;
import com.tom.persistence.dao.common.AbstractHibernateDao;
import com.tom.persistence.model.Bar;
import org.springframework.stereotype.Repository;

@Repository
public class BarDao extends AbstractHibernateDao<Bar> implements IBarDao {

    public BarDao() {
        super();

        setClazz(Bar.class);
    }

    // API

}
