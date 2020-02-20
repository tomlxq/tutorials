package com.tom.concurrency.exector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
class InvokerTest {

    @Test
    void execute() {
        final Invoker invoker = new Invoker();
        invoker.execute(()->{
            System.out.println("test task");
        });
        invoker.execute(()->{});
    }
}