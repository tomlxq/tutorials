package com.tom.persistence.service;

import com.tom.jpa.dao.IFooDao;
import com.tom.persistence.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FooService {

    @Autowired
    private IFooDao dao;

    public FooService() {
        super();
    }

    // API

    public void create(final Foo entity) {
        dao.create(entity);
    }

    public Foo findOne(final long id) {
        return dao.findOne(id);
    }

    public List<Foo> findAll() {
        return dao.findAll();
    }

}