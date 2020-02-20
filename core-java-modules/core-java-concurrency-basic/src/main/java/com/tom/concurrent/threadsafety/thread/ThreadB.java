package com.tom.concurrent.threadsafety.thread;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class ThreadB extends Thread {

    private final List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");

    @Override
    public void run() {
        letters.forEach(System.out::println);
    }
}
