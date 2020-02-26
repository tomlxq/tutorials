package com.tom.treeset;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/23
 */
public class HashSetDemoTest {
    @Test
    public void whenAddingElement_shouldAddElement() {
        Set<String> hashset = new HashSet<>();

        assertTrue(hashset.add("String Added"));
    }

    @Test
    public void whenCheckingForElement_shouldSearchForElement() {
        Set<String> hashsetContains = new HashSet<>();
        hashsetContains.add("String Added");

        assertTrue(hashsetContains.contains("String Added"));
    }

    @Test
    public void whenRemovingElement_shouldRemoveElement() {
        Set<String> removeFromHashSet = new HashSet<>();
        removeFromHashSet.add("String Added");

        assertTrue(removeFromHashSet.remove("String Added"));
    }

    @Test
    public void whenClearingHashSet_shouldClearHashSet() {
        Set<String> clearHashSet = new HashSet<>();
        clearHashSet.add("String Added");
        clearHashSet.clear();

        assertTrue(clearHashSet.isEmpty());
    }

    @Test
    public void whenCheckingTheSizeOfHashSet_shouldReturnThesize() {
        Set<String> hashSetSize = new HashSet<>();
        hashSetSize.add("String Added");

        assertEquals(1, hashSetSize.size());
    }

    @Test
    public void whenCheckingForEmptyHashSet_shouldCheckForEmpty() {
        Set<String> emptyHashSet = new HashSet<>();

        assertTrue(emptyHashSet.isEmpty());
    }

    @Test
    public void whenIteratingHashSet_shouldIterateHashSet() {
        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    @Test(expected = ConcurrentModificationException.class)
    public void whenModifyingHashSetWhileIterating_shouldThrowException() {

        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()) {
            itr.next();
            hashset.remove("Second");
        }
    }
    @Test
    public void whenRemovingElementUsingIterator_shouldRemoveElement() {

        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (element.equals("Second"))
                itr.remove();
        }

        assertEquals(2, hashset.size());
    }
    @Test
    public void initialHashSet() {
        Set<String> hashset1 = new HashSet<>();
        Set<String> hashset2 = new HashSet<>(20);
        Set<String> hashset3 = new HashSet<>(20, 0.5f);
    }
}