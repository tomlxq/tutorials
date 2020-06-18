package com.tom.persistence;

import com.tom.persistence.audit.AuditTestSuite;
import com.tom.persistence.hibernate.FooPaginationPersistenceIntegrationTest;
import com.tom.persistence.hibernate.FooSortingPersistenceIntegrationTest;
import com.tom.persistence.service.FooServiceBasicPersistenceIntegrationTest;
import com.tom.persistence.service.FooServicePersistenceIntegrationTest;
import com.tom.persistence.service.ParentServicePersistenceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ // @formatter:off
        AuditTestSuite.class
        , FooServiceBasicPersistenceIntegrationTest.class
        , FooPaginationPersistenceIntegrationTest.class
        , FooServicePersistenceIntegrationTest.class
        , ParentServicePersistenceIntegrationTest.class
        , FooSortingPersistenceIntegrationTest.class

}) // @formatter:on
public class IntegrationTestSuite {
    //
}
