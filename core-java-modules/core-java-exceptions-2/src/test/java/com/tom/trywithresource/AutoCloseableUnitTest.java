package com.tom.trywithresource;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/7/8
 */
public class AutoCloseableUnitTest {
    private static void orderOfClosingResources() throws Exception {
        try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
             AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {
            af.doSomething();
            as.doSomething();
        }
    }

    @Test
    public void testTryWithResourceOrder() throws Exception {
        orderOfClosingResources();
    }
}