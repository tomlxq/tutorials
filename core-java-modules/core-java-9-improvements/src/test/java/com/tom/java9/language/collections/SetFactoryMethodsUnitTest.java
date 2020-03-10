package com.tom.java9.language.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SetFactoryMethodsUnitTest {
    @Test
    public void whenSetCreated_traditional1_thenSuccess() {
        List<String> list = Arrays.asList("foo", "bar", "baz");

        Set<String> traditionalSet = Collections.unmodifiableSet(new HashSet<String>() {{
            add("foo");
            add("bar");
            add("baz");
        }});
        Set<String> traditionalSet2 = Stream.of("foo", "bar", "baz")
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
    }

    @Test
    public void whenSetCreated_traditional_thenSuccess() {
        Set<String> traditionalSet = new HashSet<>();
        traditionalSet.add("foo");
        traditionalSet.add("bar");
        traditionalSet.add("baz");
        traditionalSet = Collections.unmodifiableSet(traditionalSet);
        Set<String> factoryCreatedSet = Set.of("foo", "bar", "baz");
        assertEquals(traditionalSet, factoryCreatedSet);
    }

    @Test
    public void whenSetCreated_thenSuccess() {
        Set<String> traditionlSet = new HashSet<String>();
        traditionlSet.add("foo");
        traditionlSet.add("bar");
        traditionlSet.add("baz");
        Set<String> factoryCreatedSet = Set.of("foo", "bar", "baz");
        assertEquals(traditionlSet, factoryCreatedSet);
    }

    @Test(expected = IllegalArgumentException.class)
    public void onDuplicateElem_IfIllegalArgExp_thenSuccess() {
        Set.of("foo", "bar", "baz", "foo");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void onElemAdd_ifUnSupportedOpExpnThrown_thenSuccess() {
        Set<String> set = Set.of("foo", "bar");
        set.add("baz");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void onElemRemove_ifUnSupportedOpExpnThrown_thenSuccess() {
        Set<String> set = Set.of("foo", "bar", "baz");
        set.remove("foo");
    }

    @Test(expected = NullPointerException.class)
    public void onNullElem_ifNullPtrExpnThrown_thenSuccess() {
        Set.of("foo", "bar", null);
    }

    @Test
    public void ifNotHashSet_thenSuccess() {
        Set<String> list = Set.of("foo", "bar");
        assertFalse(list instanceof HashSet);
    }

    @Test
    public void ifSetSizeIsOne_thenSuccess() {
        int[] arr = {1, 2, 3, 4};
        Set<int[]> set = Set.of(arr);
        assertEquals(1, set.size());
        assertArrayEquals(arr, set.iterator().next());
    }

}