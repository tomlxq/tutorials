package com.tom.threadlocal;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
public class SharedMapWithUserContextTest {

    @Test
    public void run() throws InterruptedException{
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
        Thread.sleep(300);
        Assert.assertEquals(SharedMapWithUserContext.userContextPerUserId.size(), 2);
    }
}