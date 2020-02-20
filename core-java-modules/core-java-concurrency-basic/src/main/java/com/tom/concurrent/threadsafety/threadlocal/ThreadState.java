package com.tom.concurrent.threadsafety.threadlocal;

import com.tom.concurrent.threadsafety.services.StateHolder;

/**
 * ThreadLocal 字段与普通类字段非常相似，不同之处在于，
 * 每个通过setter / getter访问它们的线程都会获得一个独立初始化的字段副本，以便每个线程都有自己的状态。
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class ThreadState {

    public static final ThreadLocal<StateHolder> statePerThread = new ThreadLocal<StateHolder>() {

        @Override
        protected StateHolder initialValue() {
            return new StateHolder("active");
        }
    };

    public static StateHolder getState() {
        return statePerThread.get();
    }
}