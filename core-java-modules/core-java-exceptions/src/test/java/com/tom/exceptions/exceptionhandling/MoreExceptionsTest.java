package com.tom.exceptions.exceptionhandling;


import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
public class MoreExceptionsTest {

    @Test(expected = MyCheckedException.class)
    public void loadAllPlayers() throws MyCheckedException {

        Exceptions exceptions = new MoreExceptions();
        exceptions.loadAllPlayers("file");
    }
}