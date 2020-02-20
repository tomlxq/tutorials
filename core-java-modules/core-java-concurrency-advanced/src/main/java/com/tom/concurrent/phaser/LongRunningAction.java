

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
package com.tom.concurrent.phaser;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Phaser;

@Slf4j
public class LongRunningAction implements Runnable {
    private String threadName;
    private Phaser ph;

    LongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        //当我们的动作类被实例化时，我们正在使用register（）方法注册到Phaser实例。 这将增加使用该特定相位器的线程数。
        ph.register();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + ph.getPhase());
        System.out.println("Thread " + threadName + " before long running action");
        //调用arriveAndAwaitAdvance（）将导致当前线程在屏障上等待。 当到达方的数量变为与注册方的数量，将继续执行。
        ph.arriveAndAwaitAdvance();
        log.info("getPhase {}", ph.getPhase());
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //处理完成后，当前线程通过调用arriveAndDeregister（）方法注销自身。
        ph.arriveAndDeregister();
    }
}
