package com.tom.persistence.dao.impl;

import com.tom.persistence.dao.IBarDao;
import com.tom.persistence.dao.common.AbstractJpaDao;
import com.tom.persistence.model.Bar;
import org.springframework.stereotype.Repository;

@Repository
public class BarJpaDao extends AbstractJpaDao<Bar> implements IBarDao {

    public BarJpaDao() {
        super();

        setClazz(Bar.class);
    }

    // API

}
