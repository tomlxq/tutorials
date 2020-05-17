package com.tom.concurrent.threadsafety.services;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/17
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