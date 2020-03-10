package com.tom.streams.forEach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ReverseList extends ArrayList<String> {

    @Override
    public Iterator<String> iterator() {

        final int startIndex = this.size() - 1;
        final List<String> list = this;
        return new Iterator<String>() {

            int currentIndex = startIndex;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public String next() {
                String next = list.get(currentIndex);
                currentIndex--;
                return next;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        for (String s : this) {
            action.accept(s);
        }
    }


}