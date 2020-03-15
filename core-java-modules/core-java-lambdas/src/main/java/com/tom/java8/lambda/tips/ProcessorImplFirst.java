package com.tom.java8.lambda.tips;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/14
 */


import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ProcessorImplFirst<T> implements ProcessorFirst<T> {

    @Override
    public String process(Callable<String> c) throws Exception {
        return c.call();
    }

    @Override
    public String process(Supplier<String> s) {
        return s.get();
    }

   /* @Override
    public T add(T  a, T b) {
        return  a+b;
    }*/
  /* public void method() {
       String localVariable = "Local";
       Foo foo = parameter -> {
           String localVariable = parameter;
           return localVariable;
       };
   }*/
}