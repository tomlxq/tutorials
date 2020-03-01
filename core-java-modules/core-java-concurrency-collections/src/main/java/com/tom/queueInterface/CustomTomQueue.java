package com.tom.queueInterface;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * AbstractQueue是Java提供的最简单的Queue实现。
 * 它包括一些Queue接口方法的基本实现，但offer（）除外
 * 必须提供peek，poll，size和java.util的迭代器方法
 *
 * @param <T>
 */
public class CustomTomQueue<T> extends AbstractQueue<T> {

    private LinkedList<T> elements;

    public CustomTomQueue() {
        this.elements = new LinkedList<T>();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    /**
     * 必须提供offer方法的实现，该方法不允许插入空元素
     * @param t
     * @return
     */
    @Override
    public boolean offer(T t) {
        if (t == null) {
            return false;
        }
        elements.add(t);
        return true;
    }

    @Override
    public T poll() {

        Iterator<T> iter = elements.iterator();
        T t = iter.next();
        if (t != null) {
            iter.remove();
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        return elements.getFirst();
    }
}