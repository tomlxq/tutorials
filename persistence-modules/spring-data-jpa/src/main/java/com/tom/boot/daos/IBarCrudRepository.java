package com.tom.boot.daos;

import com.tom.boot.domain.Bar;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface IBarCrudRepository extends CrudRepository<Bar, Serializable> {
    //
}