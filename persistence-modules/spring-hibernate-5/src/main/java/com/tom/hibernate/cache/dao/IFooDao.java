package com.tom.hibernate.cache.dao;

import com.tom.hibernate.cache.model.Foo;

import java.util.List;

public interface IFooDao {

    Foo findOne(long id);

    List<Foo> findAll();

    void create(Foo entity);

    Foo update(Foo entity);

    void delete(Foo entity);

    void deleteById(long entityId);

}
