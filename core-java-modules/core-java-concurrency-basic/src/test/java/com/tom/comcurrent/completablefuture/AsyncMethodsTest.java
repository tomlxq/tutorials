package com.tom.comcurrent.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class AsyncMethodsTest {
    @Test
    public void test_thenApplyAsync() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApplyAsync(s -> s + " World");

        assertEquals("Hello World", future.get());
    }
}