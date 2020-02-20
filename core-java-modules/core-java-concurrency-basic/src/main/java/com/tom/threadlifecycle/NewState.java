package com.tom.threadlifecycle;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
public class NewState implements Runnable {
    @Override
    public void run() {
        while(true) {

        }
        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
