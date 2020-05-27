package com.tom.persistence.service.impl;

import com.tom.persistence.common.AbstractService;
import com.tom.persistence.common.IOperations;
import com.tom.persistence.dao.IChildDao;
import com.tom.persistence.model.Child;
import com.tom.persistence.service.IChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService extends AbstractService<Child> implements IChildService {

    @Autowired
    private IChildDao dao;

    public ChildService() {
        super();
    }

    // API

    @Override
    protected IOperations<Child> getDao() {
        return dao;
    }

}
