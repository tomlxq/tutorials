package com.tom.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tom.persistence.IOperations;
import com.tom.persistence.model.Foo;

public interface IFooService extends IOperations<Foo> {
    
    Page<Foo> findPaginated(Pageable pageable);

}
