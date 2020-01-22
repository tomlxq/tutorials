package com.tom.newline;

import org.junit.jupiter.api.Test;

import static com.tom.newline.AddingNewLineToString.add4Linux;
import static com.tom.newline.AddingNewLineToString.add4OldMacOS;
import static com.tom.newline.AddingNewLineToString.add4Win;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
class AddingNewLineToStringTest {

    @Test
    void add4LinuxTest() {
        add4Linux();
    }

    @Test
    void add4WinTest() {
        add4Win();
    }

    @Test
    void add4OldMacOSTest() {
        add4OldMacOS();
    }
}