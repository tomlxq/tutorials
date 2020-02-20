package com.tom.concurrent.locks;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
@Slf4j
class ReentrantLockWithConditionTest {
    @Test
    void name() {

            final int threadCount = 2;
            ReentrantLockWithCondition object = new ReentrantLockWithCondition();
            final ExecutorService service = Executors.newFixedThreadPool(threadCount);
            service.execute(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        object.pushToStack("Item " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });

            service.execute(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        log.info("Item popped " + object.popFromStack());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });

            service.shutdown();

    }
}