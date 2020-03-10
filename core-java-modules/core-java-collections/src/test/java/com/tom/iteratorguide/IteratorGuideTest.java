package com.tom.iteratorguide;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/8
 */
public class IteratorGuideTest {
    List<String> items = new ArrayList<>(List.of("one", "two", "three"));

    @Test
    public void main() {
        final Iterator<String> iter = items.iterator();
        iter.forEachRemaining(System.out::println);
    }

    @Test
    public void listIterator() {
        ListIterator<String> listIterator = items.listIterator(items.size());
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.println(previous);
        }
    }

    @Test
    public void get_nextIndex_previousIndex() {
        ListIterator<String> listIterator = items.listIterator();
        while (listIterator.hasNext()) {
            String nextWithIndex = items.get(listIterator.nextIndex());
            String next = listIterator.next();
            if ("ONE".equals(next)) {
                listIterator.set("SWAPPED");
            }
        }
        listIterator.add("FOUR");
        while (listIterator.hasPrevious()) {
            String previousWithIndex = items.get(listIterator.previousIndex());
            String previous = listIterator.previous();
            System.out.println(previous);
        }

    }
}