package com.tom.concurrent.threadsafety.services;

import com.tom.concurrent.threadsafety.callables.MessageServiceCallable;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class MessageServiceTest {

    @Test
    public void getMessage() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MessageService messageService = new MessageService("Welcome to tom!");
        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        System.out.println(future1.get());
        System.out.println(future2.get());
    }

    @Test
    public void whenCalledgetMessage_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MessageService messageService = new MessageService("Welcome to tom!");
        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));

        assertThat(future1.get()).isEqualTo("Welcome to tom!");
        assertThat(future2.get()).isEqualTo("Welcome to tom!");
    }
}