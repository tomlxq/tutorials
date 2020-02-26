package com.tom.treeset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
public class TreeSetDemoTest {
    @Test
    public void whenAddingElement_shouldAddElement() {
        Set<String> treeSet = new TreeSet<>();
        assertTrue(treeSet.add("String Added"));
    }

    @Test
    public void whenCheckingForElement_shouldSearchForElement() {
        Set<String> treeSetContains = new TreeSet<>();
        treeSetContains.add("String Added");

        assertTrue(treeSetContains.contains("String Added"));
    }

    @Test
    public void whenRemovingElement_shouldRemoveElement() {
        Set<String> removeFromTreeSet = new TreeSet<>();
        removeFromTreeSet.add("String Added");

        assertTrue(removeFromTreeSet.remove("String Added"));
    }

    @Test
    public void whenClearingTreeSet_shouldClearTreeSet() {
        Set<String> clearTreeSet = new TreeSet<>();
        clearTreeSet.add("String Added");
        clearTreeSet.clear();

        assertTrue(clearTreeSet.isEmpty());
    }

    @Test
    public void whenCheckingTheSizeOfTreeSet_shouldReturnThesize() {
        Set<String> treeSetSize = new TreeSet<>();
        treeSetSize.add("String Added");

        assertEquals(1, treeSetSize.size());
    }

    @Test
    public void whenCheckingForEmptyTreeSet_shouldCheckForEmpty() {
        Set<String> emptyTreeSet = new TreeSet<>();

        assertTrue(emptyTreeSet.isEmpty());
    }

    @Test
    public void whenIteratingTreeSet_shouldIterateTreeSetInAscendingOrder() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    public void whenIteratingTreeSet_shouldIterateTreeSetInDescendingOrder() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.descendingIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModifyingTreeSetWhileIterating_shouldThrowException() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            itr.next();
            treeSet.remove("Second");
        }
    }

    @Test
    public void whenRemovingElementUsingIterator_shouldRemoveElement() {

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (element.equals("Second"))
                itr.remove();
        }

        assertEquals(2, treeSet.size());
    }

    @Test
    public void whenCheckingFirstElement_shouldReturnFirstElement() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");

        assertEquals("First", treeSet.first());
    }

    @Test
    public void whenCheckingFirstElement_shouldReturnFirstElement_exception() {
        TreeSet<String> treeSet = new TreeSet<>();
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> treeSet.first());

    }

    @Test
    public void whenCheckingLastElement_shouldReturnLastElement() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Last");
        assertEquals("Last", treeSet.last());
    }

    @Test
    public void whenCheckingLastElement_shouldReturnLastElementLast() {
        TreeSet<String> treeSet = new TreeSet<>();
        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> treeSet.last());
    }

    @Test
    public void whenUsingSubSet_shouldReturnSubSetElements() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> expectedSet = new TreeSet<>();
        expectedSet.add(2);
        expectedSet.add(3);
        expectedSet.add(4);
        expectedSet.add(5);

        Set<Integer> subSet = treeSet.subSet(2, 6);

        assertEquals(expectedSet, subSet);
    }

    @Test
    public void whenUsingHeadSet_shouldReturnHeadSetElements() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> subSet = treeSet.headSet(6);

        assertEquals(subSet, treeSet.subSet(1, 6));
    }

    @Test
    public void whenUsingTailSet_shouldReturnTailSetElements() {
        NavigableSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> subSet = treeSet.tailSet(3);

        assertEquals(subSet, treeSet.subSet(3, true, 6, true));
    }

    @Test(expected = NullPointerException.class)
    public void whenAddingNullToNonEmptyTreeSet_shouldThrowException() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add(null);
    }
    @Data
    class Element {
        private Integer id;
    }

    Comparator<Element> comparator = (ele1, ele2) -> {
        return ele1.getId().compareTo(ele2.getId());
    };

    @Test
    public void whenUsingComparator_shouldSortAndInsertElements() {
        Set<Element> treeSet = new TreeSet<>(comparator);
        Element ele1 = new Element();
        ele1.setId(100);
        Element ele2 = new Element();
        ele2.setId(200);

        treeSet.add(ele1);
        treeSet.add(ele2);

        System.out.println(treeSet);
    }
}