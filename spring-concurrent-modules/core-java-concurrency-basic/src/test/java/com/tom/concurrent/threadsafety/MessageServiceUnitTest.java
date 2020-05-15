package com.tom.concurrent.threadsafety;

import com.tom.concurrent.threadsafety.callables.MessageServiceCallable;
import com.tom.concurrent.threadsafety.services.MessageService;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageServiceUnitTest {

    @Test
    public void whenCalledgetMessage_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MessageService messageService = new MessageService("Welcome to Tom!");
        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));

        assertThat(future1.get()).isEqualTo("Welcome to Tom!");
        assertThat(future2.get()).isEqualTo("Welcome to Tom!");
    }
}
