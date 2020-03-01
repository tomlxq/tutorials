package com.tom.concurrent.skiplist;

import com.tom.concurrent.skiplist.Event;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/25
 */
@Slf4j
public class EventWindowSortTest {
    EventWindowSort eventWindowSort=null;
    @Before
    public void setUp() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
         eventWindowSort = new EventWindowSort();
        int numberOfThreads = 2;

        Runnable producer = () -> IntStream
                .rangeClosed(0, 100)
                .forEach(index -> eventWindowSort.acceptEvent(
                        new Event(ZonedDateTime.now().minusSeconds(index), UUID.randomUUID().toString()))
                );

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(producer);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
    }

    @Test
    public void name() throws InterruptedException {

        ConcurrentNavigableMap<ZonedDateTime, String> eventsFromLastMinute
                = eventWindowSort.getEventsFromLastMinute();
        long eventsOlderThanOneMinute = eventsFromLastMinute
                .entrySet()
                .stream()
                .filter(e -> e.getKey().isBefore(ZonedDateTime.now().minusMinutes(1)))
                .count();

        assertEquals(eventsOlderThanOneMinute, 0);

        long eventYoungerThanOneMinute = eventsFromLastMinute
                .entrySet()
                .stream()
                .filter(e -> e.getKey().isAfter(ZonedDateTime.now().minusMinutes(1)))
                .count();
        log.info("{}", eventYoungerThanOneMinute);
        assertTrue(eventYoungerThanOneMinute > 0);




    }

    @Test
    public void name2() throws InterruptedException {

        ConcurrentNavigableMap<ZonedDateTime, String> eventsFromLastMinute
                = eventWindowSort.getEventsOlderThatOneMinute();
        long eventsOlderThanOneMinute = eventsFromLastMinute
                .entrySet()
                .stream()
                .filter(e -> e.getKey().isBefore(ZonedDateTime.now().minusMinutes(1)))
                .count();

        assertTrue(eventsOlderThanOneMinute > 0);

        long eventYoungerThanOneMinute = eventsFromLastMinute
                .entrySet()
                .stream()
                .filter(e -> e.getKey().isAfter(ZonedDateTime.now().minusMinutes(1)))
                .count();

        assertEquals(eventYoungerThanOneMinute, 0);
    }
}