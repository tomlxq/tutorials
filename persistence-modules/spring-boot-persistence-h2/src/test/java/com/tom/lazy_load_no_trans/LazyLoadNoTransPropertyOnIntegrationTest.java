package com.tom.lazy_load_no_trans;

import com.tom.h2db.lazy_load_no_trans.LazyLoadNoTransSpringBootApplication;
import com.tom.h2db.lazy_load_no_trans.service.ServiceLayer;
import com.vladmihalcea.sql.SQLStatementCountValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LazyLoadNoTransSpringBootApplication.class)
@ActiveProfiles("lazy-load-no-trans-on")
public class LazyLoadNoTransPropertyOnIntegrationTest {

    private static final long EXPECTED_DOCS_COLLECTION_SIZE = 6;
    private static final long EXPECTED_USERS_COUNT = 5;
    @Autowired
    private ServiceLayer serviceLayer;

    @Test
    public void whenCallNonTransactionalMethodWithPropertyOn_thenGetNplusOne() {
        SQLStatementCountValidator.reset();

        long docsCount = serviceLayer.countAllDocsNonTransactional();

        assertEquals(EXPECTED_DOCS_COLLECTION_SIZE, docsCount);

        SQLStatementCountValidator.assertSelectCount(EXPECTED_USERS_COUNT + 1);
    }

    @Test
    public void whenCallTransactionalMethodWithPropertyOn_thenTestPass() {
        SQLStatementCountValidator.reset();

        long docsCount = serviceLayer.countAllDocsTransactional();

        assertEquals(EXPECTED_DOCS_COLLECTION_SIZE, docsCount);

        SQLStatementCountValidator.assertSelectCount(2);
    }
}
