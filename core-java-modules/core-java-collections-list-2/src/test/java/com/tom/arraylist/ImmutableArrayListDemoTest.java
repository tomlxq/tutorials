package com.tom.arraylist;


import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 如何使用核心JDK，Google Guava或Apache Commons Collections从现有ArrayList轻松创建不可修改的列表。
 *
 * @author TomLuo
 * @date 2020/2/20
 */
public class ImmutableArrayListDemoTest {
    /**
     * With the JDK
     */
    @Test(expected = UnsupportedOperationException.class)
    public void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.add("four");
    }

    /**
     * With Java 9
     */
    @Test(expected = UnsupportedOperationException.class)
    public final void givenUsingTheJava9_whenUnmodifiableListIsCreated_thenNotModifiable() {
        final List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        final List<String> unmodifiableList = List.of(list.toArray(new String[]{}));
        unmodifiableList.add("four");
    }

    /**
     * With Guava
     */
    @Test(expected = UnsupportedOperationException.class)
    public void givenUsingGuava_whenUnmodifiableListIsCreated_thenNotModifiable() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = ImmutableList.copyOf(list);
        unmodifiableList.add("four");
    }

    /**
     * With the Apache Collections Commons
     */
    @Test(expected = UnsupportedOperationException.class)
    public void givenUsingCommonsCollections_whenUnmodifiableListIsCreated_thenNotModifiable() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = ListUtils.unmodifiableList(list);
        unmodifiableList.add("four");
    }
}