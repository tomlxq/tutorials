package com.tom.jpa.dao;

import com.tom.persistence.model.Foo;

import java.util.List;

public interface IFooDao {

    Foo findOne(long id);

    List<Foo> findAll();

    Foo create(Foo entity);

    Foo update(Foo entity);

    void delete(Foo entity);

    void deleteById(long entityId);

}
