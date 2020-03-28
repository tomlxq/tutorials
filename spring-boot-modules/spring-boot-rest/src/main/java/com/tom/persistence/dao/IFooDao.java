package com.tom.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.persistence.model.Foo;

public interface IFooDao extends JpaRepository<Foo, Long> {
    
}
