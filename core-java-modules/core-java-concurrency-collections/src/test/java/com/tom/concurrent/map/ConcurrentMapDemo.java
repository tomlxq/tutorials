package com.tom.concurrent.map;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/25
 */
public class ConcurrentMapDemo {
    @Test
    public void givenHashMap_whenSumParallel_thenError() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> sumList = parallelSum100(map, 100);

        assertNotEquals(1, sumList
                .stream()
                .distinct()
                .count());
        long wrongResultCount = sumList
                .stream()
                .filter(num -> num != 100)
                .count();

        assertTrue(wrongResultCount > 0);
    }

    private List<Integer> parallelSum100(Map<String, Integer> map,
                                         int executionTimes) throws InterruptedException {
        List<Integer> sumList = new ArrayList<>(1000);
        for (int i = 0; i < executionTimes; i++) {
            map.put("test", 0);
            ExecutorService executorService =
                    Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                executorService.execute(() -> {
                    for (int k = 0; k < 10; k++)
                        map.computeIfPresent(
                                "test",
                                (key, value) -> value + 1
                        );
                });
            }
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            sumList.add(map.get("test"));
        }
        return sumList;
    }

    @Test
    public void givenConcurrentMap_whenSumParallel_thenCorrect()
            throws Exception {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        List<Integer> sumList = parallelSum100(map, 1000);

        assertEquals(1, sumList
                .stream()
                .distinct()
                .count());
        long wrongResultCount = sumList
                .stream()
                .filter(num -> num != 100)
                .count();

        assertEquals(0, wrongResultCount);
    }

    Map<String, Object> concurrentMap = new ConcurrentHashMap<>();

    @Test(expected = NullPointerException.class)
    public void givenConcurrentHashMap_whenPutWithNullKey_thenThrowsNPE() {
        concurrentMap.put(null, new Object());
    }

    @Test(expected = NullPointerException.class)
    public void givenConcurrentHashMap_whenPutNullValue_thenThrowsNPE() {
        concurrentMap.put("test", null);
    }

    @Test
    public void givenKeyPresent_whenComputeRemappingNull_thenMappingRemoved() {
        Object oldValue = new Object();
        concurrentMap.put("test", oldValue);
        concurrentMap.compute("test", (s, o) -> null);

        assertNull(concurrentMap.get("test"));
    }


    ExecutorService executorService =
            Executors.newFixedThreadPool(4);
    int MAX_SIZE = 200;
    List<Integer> mapSizes = new ArrayList<>();

    @Test
    public void givenConcurrentMap_whenUpdatingAndGetSize_thenError()
            throws InterruptedException {

        Runnable collectMapSizes = () -> {
            for (int i = 0; i < MAX_SIZE; i++) {
                mapSizes.add(concurrentMap.size());
            }
        };
        Runnable updateMapData = () -> {
            for (int i = 0; i < MAX_SIZE; i++) {
                concurrentMap.put(String.valueOf(i), i);
            }
        };
        executorService.execute(updateMapData);
        executorService.execute(collectMapSizes);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        assertNotEquals(MAX_SIZE, mapSizes.get(MAX_SIZE - 1).intValue());
        assertEquals(MAX_SIZE, concurrentMap.size());
    }
}
