/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/10
 */
package com.tom.concurrent.volatilekeyword;


public class SharedObject {
    private volatile int count = 0;

    void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
