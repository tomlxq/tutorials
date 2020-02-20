package com.tom.concurrency.threadfactory;


import com.tom.concurrency.executorservice.Task;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class TomThreadFactoryTest {
    @Test
    public void name() {
        TomThreadFactory factory = new TomThreadFactory(
                "TomThreadFactory");
        for (int i = 0; i < 10; i++) {
            Thread t = factory.newThread(new Task());
            t.start();
        }
    }


}