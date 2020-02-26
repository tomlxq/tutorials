package com.tom.order;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;


import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/23
 */
public class OderTest {

    @Test
    public void whenInsertObjectsHashMap_thenRandomOrder() {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(3, "TreeMap");
        hashmap.put(2, "vs");
        hashmap.put(1, "HashMap");

        assertThat(hashmap.keySet(), containsInAnyOrder(1, 2, 3));
    }
    @Test
    public void whenInsertObjectsTreeMap_thenNaturalOrder() {
        Map<Integer, String> treemap = new TreeMap<>();
        treemap.put(3, "TreeMap");
        treemap.put(2, "vs");
        treemap.put(1, "HashMap");

        assertThat(treemap.keySet(), contains(1, 2, 3));
    }
    @Test
    public void whenInsertNullInHashMap_thenInsertsNull() {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(null, null);

        assertNull(hashmap.get(null));
    }
    @Test(expected = NullPointerException.class)
    public void whenInsertNullInTreeMap_thenException() {
        Map<Integer, String> treemap = new TreeMap<>();
        treemap.put(null, "NullPointerException");
    }

    @Test
    public void givenHashMapAndTreeMap_whenputDuplicates_thenOnlyUnique() {
        Map<Integer, String> treeMap = new HashMap<>();
        treeMap.put(1, "guava");
        treeMap.put(1, "guava");

        assertTrue(treeMap.size() == 1);

        Map<Integer, String> treeMap2 = new TreeMap<>();
        treeMap2.put(1, "guava");
        treeMap2.put(1, "guava");

        assertTrue(treeMap2.size() == 1);
    }
    @Test
    public void whenModifyMapDuringIteration_thenThrowExecption() {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(1, "One");
        hashmap.put(2, "Two");

        Executable executable = () -> hashmap
                .forEach((key,value) -> hashmap.remove(1));

        assertThrows(ConcurrentModificationException.class, executable);
    }
}
