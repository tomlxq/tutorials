package com.tom.eclipsecollections;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/10
 */
public class InitCollectionDemoTest {
    @Test
    public void name() {
        MutableList<String> list = FastList.newListWith(
                "Porsche", "Volkswagen", "Toyota", "Mercedes", "Toyota");
        assertEquals("Porsche", list.get(0));
        assertEquals(5, list.size());
        Set<String> comparison = UnifiedSet.newSetWith(
                "Porsche", "Volkswagen", "Toyota", "Mercedes", "Mercedes");
        assertEquals(4, comparison.size());
        MutableBag<String> bag = HashBag.newBagWith(
                "Porsche", "Volkswagen", "Toyota", "Porsche", "Mercedes");
        assertEquals(5, bag.size());
    }

    @Test
    public void init_UnifiedMap() {
        Pair<Integer, String> pair1 = Tuples.pair(1, "One");
        Pair<Integer, String> pair2 = Tuples.pair(2, "Two");
        Pair<Integer, String> pair3 = Tuples.pair(3, "Three");

        UnifiedMap<Integer, String> map = new UnifiedMap<>(pair1, pair2, pair3);
        assertEquals("One", map.get(1));
        assertEquals("One", map.getFirst());
        assertEquals("Three", map.getLast());

        assertEquals("One", map.min());
        assertEquals("Three", map.max());
        assertEquals(3, map.size());

    }

    @Test
    public void init_UnifiedMap_use_java_collection() {
        Pair<Integer, String> pair1 = Tuples.pair(1, "One");
        Pair<Integer, String> pair2 = Tuples.pair(2, "Two");
        Pair<Integer, String> pair3 = Tuples.pair(3, "Three");

        UnifiedMap<Integer, String> map = new UnifiedMap<>(pair1, pair2, pair3);


        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertEquals(3, map.size());


    }

}
