package com.tom.anonymous;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
public class AnonymousDemo {
    int count = 1;
    Runnable action = new Runnable() {
        @Override
        public void run() {
            System.out.println("Runnable with captured variables: " + count);
        }
    };
}
