/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/21
 */
package com.tom.list.random;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class RandomListElementUnitTest {

    @Test
    public void givenList_whenRandomIndexChosen_shouldReturnARandomElementUsingRandom() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3);
        Random rand = new Random();
        log.info("{}", givenList.get(rand.nextInt(givenList.size())));
    }

    @Test
    public void givenList_whenRandomIndexChosen_shouldReturnARandomElementUsingMathRandom() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3);

        givenList.get((int) (Math.random() * givenList.size()));
    }

    @Test
    public void givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat() {
        Random rand = new Random();
        List<String> givenList = Lists.newArrayList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            givenList.get(randomIndex);
        }
    }

    @Test
    public void givenList_whenNumberElementsChosen_shouldReturnRandomElementsNoRepeat() {
        Random rand = new Random();
        List<String> givenList = Lists.newArrayList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            givenList.get(randomIndex);
            givenList.remove(randomIndex);
        }
    }

    @Test
    public void givenList_whenSeriesLengthChosen_shouldReturnRandomSeries() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        Collections.shuffle(givenList);
        log.info("{}", givenList);
        int randomSeriesLength = 3;
        givenList.subList(0, randomSeriesLength - 1);
    }

    @Test
    public void givenList_whenRandomIndexChosen_shouldReturnElementThreadSafely() {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        int randomIndex = ThreadLocalRandom.current().nextInt(10) % givenList.size();

        givenList.get(randomIndex);
    }

}