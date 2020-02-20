package com.tom.immutableobjects;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
@Slf4j
public class ImmutableObjectDemoTest {
    /**
     * The API gives us read-only methods, it should never include methods that change the internal state of the object.
     */
    @Test
    public void testString() {
        String name = "tom";
        String newName = name.replace("m", "----");

        assertEquals("tom", name);
        assertEquals("to----", newName);
    }

    @Test
    public void testString2() {
        final List<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("tom");
        assertNotEquals(0, strings.size());
    }

    @Test
    public void testString3() {
        String s1 = "Hello World";
        String s2 = "Hello World";

        assertThat(s1 == s2).isTrue();
        assertEquals(s2.hashCode(), s1.hashCode());
        final int beforeHashCode = s1.hashCode();
        log.info("before {}", beforeHashCode);
        s2 = "Hello World1";
        final int afterHashCode = s1.hashCode();
        log.info("after {}", afterHashCode);
        assertEquals(beforeHashCode, afterHashCode);
    }



}