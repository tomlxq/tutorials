package com.tom.threadlifecycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class WaitingStateTest {

    @Test
    public void run() throws IOException {
        WaitingState.t1  = new Thread(new WaitingState());
        WaitingState.t1.start();

        log.info("{}", WaitingState.t1.getState());
        Assert.assertEquals(WaitingState.t1.getState().name(), Thread.State.WAITING.name());
        System.in.read();
    }
}