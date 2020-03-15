package com.tom.java8.lambda.tips;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public interface ProcessorFirst<T> {

    String process(Callable<String> c) throws Exception;

    String process(Supplier<String> s);
    /* T add(T a,T b);*/
}