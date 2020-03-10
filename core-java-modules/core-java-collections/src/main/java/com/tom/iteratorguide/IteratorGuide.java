package com.tom.iteratorguide;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorGuide {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("ONE");
        items.add("TWO");
        items.add("THREE");
        Iterator<String> iter = items.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
            iter.remove();
        }
        ListIterator<String> listIterator = items.listIterator(items.size());
        listIterator.forEachRemaining(e -> {
            System.out.println(e);
        });
    }
}