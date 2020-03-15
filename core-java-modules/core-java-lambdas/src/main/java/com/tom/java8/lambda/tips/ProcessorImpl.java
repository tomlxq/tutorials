package com.tom.java8.lambda.tips;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/14
 */


import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ProcessorImpl implements Processor {

    @Override
    public String processWithCallable(Callable<String> c) throws Exception {
        return c.call();
    }

    @Override
    public String processWithSupplier(Supplier<String> s) {
        return s.get();
    }
}