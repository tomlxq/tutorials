package com.tom.persistence.deletion.config;

import com.tom.spring.PersistenceJPAConfigL2Cache;

public class PersistenceJPAConfigDeletion extends PersistenceJPAConfigL2Cache {

    public PersistenceJPAConfigDeletion() {
        super();
    }

    @Override
    protected String[] getPackagesToScan() {
        return new String[]{"com.tom.persistence.deletion.model", "com.tom.persistence.model"};
    }
}