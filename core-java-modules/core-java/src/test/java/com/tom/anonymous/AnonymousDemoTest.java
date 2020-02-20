package com.tom.anonymous;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
public class AnonymousDemoTest {
    @Test
    public void name() {
        AnonymousDemo anonymousDemo=new AnonymousDemo();
         Runnable action = anonymousDemo.action;
        action.run();
    }


}