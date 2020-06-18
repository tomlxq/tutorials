package com.tom.persistence.dao;

import com.tom.persistence.dao.common.IAuditOperations;
import com.tom.persistence.model.Foo;

public interface IFooAuditableDao extends IFooDao, IAuditOperations<Foo> {
    //
}