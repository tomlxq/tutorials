package com.tom.persistence.service;

import com.tom.persistence.dao.common.IAuditOperations;
import com.tom.persistence.model.Bar;

public interface IBarAuditableService extends IBarService, IAuditOperations<Bar> {

}
