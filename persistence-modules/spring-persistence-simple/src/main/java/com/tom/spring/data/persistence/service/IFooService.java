package com.tom.spring.data.persistence.service;

import com.tom.persistence.dao.common.IOperations;
import com.tom.spring.data.persistence.model.Foo;

public interface IFooService extends IOperations<Foo> {

    Foo retrieveByName(String name);

}
