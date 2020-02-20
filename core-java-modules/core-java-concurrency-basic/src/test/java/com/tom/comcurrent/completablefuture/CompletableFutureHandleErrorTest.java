package com.tom.comcurrent.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class CompletableFutureHandleErrorTest {
    @Test
    public void test_handle_error() throws InterruptedException, ExecutionException {
        String name = null;
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) ->s !=null?s :"Hello, Stranger!");

    assertEquals("Hello, Stranger!",completableFuture.get());
}
    @Test(expected = ExecutionException.class)
    public void test_handle_error2() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

// ...

        completableFuture.completeExceptionally(
                new RuntimeException("Calculation failed!"));

// ...

        completableFuture.get(); // ExecutionException
    }
}