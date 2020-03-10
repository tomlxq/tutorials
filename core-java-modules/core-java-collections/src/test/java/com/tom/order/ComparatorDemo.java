package com.tom.order;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/8
 */
public class ComparatorDemo {
    @Test
    public void custom_comparator() {
        List<Integer> list1 = Arrays.asList(5, 2, 3, 4, 1);
        Collections.sort(list1);
        assertEquals(Integer.valueOf(1), list1.get(0));
        Collections.sort(list1, (a, b) -> b - a);
        assertEquals(Integer.valueOf(5), list1.get(0));
    }
}
