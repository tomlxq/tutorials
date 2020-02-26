package com.tom.intersection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
public class IntersectionDemoTest {
    List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
    List<String> otherList = Arrays.asList("red", "green", "green", "yellow");

    @Test
    public void test_intersection() {
        Set<String> result = list.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());

        Set<String> commonElements = new HashSet(Arrays.asList("red", "green"));

        Assert.assertEquals(commonElements, result);
    }
}