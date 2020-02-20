package com.tom.concurrency.exector;

import java.util.concurrent.Executor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class Invoker implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}
