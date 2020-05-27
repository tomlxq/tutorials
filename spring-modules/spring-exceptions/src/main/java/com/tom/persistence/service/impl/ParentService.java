package com.tom.persistence.service.impl;

import com.tom.persistence.common.AbstractService;
import com.tom.persistence.common.IOperations;
import com.tom.persistence.dao.IParentDao;
import com.tom.persistence.model.Parent;
import com.tom.persistence.service.IParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService extends AbstractService<Parent> implements IParentService {

    @Autowired
    private IParentDao dao;

    public ParentService() {
        super();
    }

    // API

    @Override
    protected IOperations<Parent> getDao() {
        return dao;
    }

}
