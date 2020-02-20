package com.tom.switchuse;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
public class SwitchDemoTest {
    SwitchDemo switchDemo = null;

    @Before
    public void setUp() throws Exception {
        switchDemo = new SwitchDemo();

    }

    @Test(expected = NullPointerException.class)
    public void whenSwitchArgumentIsNull_thenNullPointerException() {
        String animal = null;
        assertEquals("domestic animal", switchDemo.exampleOfSwitch(animal));
    }

    @Test
    public void whenCompareStrings_thenByEqual() {
        String animal = new String("DOG");
        assertEquals("domestic animal", switchDemo.exampleOfSwitch(animal));
    }
}