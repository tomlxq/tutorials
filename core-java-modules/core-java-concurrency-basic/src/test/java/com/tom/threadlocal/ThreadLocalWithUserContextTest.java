package com.tom.threadlocal;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
public class ThreadLocalWithUserContextTest {

    @Test
    public void run() throws InterruptedException {
        ThreadLocalWithUserContext firstUser
                = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser
                = new ThreadLocalWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        Thread.sleep(300);
        //Assert.assertEquals(ThreadLocalWithUserContext.size(), 2);
    }
}