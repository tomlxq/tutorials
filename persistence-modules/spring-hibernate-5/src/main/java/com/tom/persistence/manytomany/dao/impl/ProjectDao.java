package com.tom.persistence.manytomany.dao.impl;

import com.tom.hibernate.manytomany.model.Project;
import com.tom.persistence.dao.common.AbstractHibernateDao;
import com.tom.persistence.manytomany.dao.IProjectDao;
import org.springframework.stereotype.Repository;


@Repository
public class ProjectDao extends AbstractHibernateDao<Project> implements IProjectDao {

    public ProjectDao() {
        super();

        setClazz(Project.class);
    }
}
