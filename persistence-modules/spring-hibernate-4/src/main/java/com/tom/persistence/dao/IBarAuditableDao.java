package com.tom.persistence.dao;

import com.tom.persistence.dao.common.IAuditOperations;
import com.tom.persistence.model.Bar;

public interface IBarAuditableDao extends IBarDao, IAuditOperations<Bar> {
    //
}
