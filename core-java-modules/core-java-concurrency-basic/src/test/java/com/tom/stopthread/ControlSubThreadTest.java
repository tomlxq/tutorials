package com.tom.stopthread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.jayway.awaitility.Awaitility.await;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.jayway.awaitility.Awaitility;
/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class ControlSubThreadTest {
    @Test
    public void whenStoppedThreadIsStopped() throws InterruptedException {

        int interval = 5;

        ControlSubThread controlSubThread = new ControlSubThread(interval);
        controlSubThread.start();

        // Give things a chance to get set up
        Thread.sleep(interval);
        assertTrue(controlSubThread.isRunning());
        assertFalse(controlSubThread.isStopped());

        // Stop it and make sure the flags have been reversed
        controlSubThread.stop();
        await()
                .until(() -> assertTrue(controlSubThread.isStopped()));
    }

    @Test
    public void whenInterruptedThreadIsStopped() throws InterruptedException {

        int interval = 50;

        ControlSubThread controlSubThread = new ControlSubThread(interval);
        controlSubThread.start();

        // Give things a chance to get set up
        Thread.sleep(interval);
        assertTrue(controlSubThread.isRunning());
        assertFalse(controlSubThread.isStopped());

        // Stop it and make sure the flags have been reversed
        controlSubThread.interrupt();

        // Wait less than the time we would normally sleep, and make sure we exited.
        Awaitility.await()
                .pollDelay(2, TimeUnit.MILLISECONDS)
                .atMost(interval/ 10, TimeUnit.MILLISECONDS)
                .until(controlSubThread::isStopped);
    }

}