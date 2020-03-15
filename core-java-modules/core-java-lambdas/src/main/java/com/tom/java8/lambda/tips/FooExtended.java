package com.tom.java8.lambda.tips;


@FunctionalInterface
public interface FooExtended extends Baz, Bar {

    @Override
    default String defaultMethod() {
        return Bar.super.defaultMethod();
    }

}