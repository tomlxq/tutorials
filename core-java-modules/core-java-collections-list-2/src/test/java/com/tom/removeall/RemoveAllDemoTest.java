package com.tom.removeall;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
public class RemoveAllDemoTest {
    List<Integer> list = list(1, 2, 3, 1, 5);

    private List<Integer> list(Integer... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    @Test
    public void test_with_loop() {
        Integer element = 1;
        while (list.contains(element)) {
            list.remove(element);
        }
        Assert.assertEquals(list, Arrays.asList(2, 3, 5));
    }

    void removeAll(List<Integer> list, int element) {
        while (list.contains(element)) {
            list.remove(element);
        }
    }

    @Test
    public void remove_loop_throw_IndexOutOfBoundsException() {
        // given
        List<Integer> list = list(1, 2, 3);
        int valueToRemove = 1;

        // when
        assertThatThrownBy(() -> removeAll(list, valueToRemove))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    void removeAll2(List<Integer> list, Integer element) {
        while (list.contains(element)) {
            list.remove(element);
        }
    }

    @Test
    public void remove_loop_workOK() {
        // given
        List<Integer> list = list(1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAll2(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    void removeAll3(List<Integer> list, Integer element) {
        int index;
        while ((index = list.indexOf(element)) >= 0) {
            list.remove(index);
        }
    }

    @Test
    public void remove_loop_with_index() {
        // given
        List<Integer> list = list(1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAll3(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    void removeAll4(List<Integer> list, Integer element) {
        while (list.remove(element)) ;
    }

    @Test
    public void remove_loop_with_repeat() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAll4(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    void removeAll5(List<Integer> list, int element) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(element, list.get(i))) {
                list.remove(i);
            }
        }
    }

    @Test
    public void remove_for() {
        // given
        List<Integer> list = list(1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAll5(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    @Test
    public void remove_for2() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAll5(list, valueToRemove);

        // then
        assertThat(list).isNotEqualTo(list(2, 3));
    }

    void removeAll6(List<Integer> list, int element) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(element, list.get(i))) {
                list.remove(i);
                i--;
            }
        }
    }

    @Test
    public void remove_for6() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAll6(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    void removeAll7(List<Integer> list, int element) {
        for (int i = 0; i < list.size(); ) {
            if (Objects.equals(element, list.get(i))) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    @Test
    public void remove_for7() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAll7(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    void removeWithForEachLoop(List<Integer> list, int element) {
        for (Integer number : list) {
            if (Objects.equals(number, element)) {
                list.remove(number);
            }
        }
    }

    @Test
    public void removeWithForEachLoop() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        assertThatThrownBy(() -> removeWithForEachLoop(list, valueToRemove))
                .isInstanceOf(ConcurrentModificationException.class);
    }

    void removeWithIterator(List<Integer> list, int element) {
        for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
            Integer number = i.next();
            if (Objects.equals(number, element)) {
                ((Iterator) i).remove();
            }
        }
    }

    @Test
    public void removeWithIterator() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        removeWithIterator(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    List<Integer> removeAllWithCreateNewList(List<Integer> list, int element) {
        List<Integer> remainingElements = new ArrayList<>();
        for (Integer number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }
        return remainingElements;
    }

    @Test
    public void removeAllWithCreateNewList() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        List<Integer> result = removeAllWithCreateNewList(list, valueToRemove);

        // then
        assertThat(result).isEqualTo(list(2, 3));
    }

    void removeAllClearOldList(List<Integer> list, int element) {
        List<Integer> remainingElements = new ArrayList<>();
        for (Integer number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }

        list.clear();
        list.addAll(remainingElements);
    }

    @Test
    public void removeAllClearOldList() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAllClearOldList(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }

    List<Integer> removeAllWithLambda(List<Integer> list, int element) {
        return list.stream()
                .filter(e -> !Objects.equals(e, element))
                .collect(Collectors.toList());
    }

    @Test
    public void removeAllWithLambda() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        List<Integer> result = removeAllWithLambda(list, valueToRemove);

        // then
        assertThat(result).isEqualTo(list(2, 3));
    }
    void removeAllWithRemoveIf(List<Integer> list, int element) {
        list.removeIf(n -> Objects.equals(n, element));
    }
    @Test
    public void removeAllWithRemoveIf() {
        // given
        List<Integer> list = list(1, 1, 2, 3);
        int valueToRemove = 1;

        // when
        removeAllWithRemoveIf(list, valueToRemove);

        // then
        assertThat(list).isEqualTo(list(2, 3));
    }
}