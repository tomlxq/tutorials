package com.tom.persistence.manytomany.dao.impl;

import com.tom.hibernate.manytomany.model.Employee;
import com.tom.persistence.dao.common.AbstractHibernateDao;
import com.tom.persistence.manytomany.dao.IEmployeeDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends AbstractHibernateDao<Employee> implements IEmployeeDao {

    public EmployeeDao() {
        super();

        setClazz(Employee.class);
    }
}
