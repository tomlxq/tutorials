package com.tom.comcurrent.completablefuture;



import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
public class CompletableFutureDemoTest {

    @Test
    public  void calculateAsync() throws InterruptedException, ExecutionException {
        CompletableFutureDemo completableFutureDemo=new CompletableFutureDemo();
        Future<String> completableFuture = completableFutureDemo.calculateAsync();
        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    @Test
    public void test_completedFuture() throws ExecutionException, InterruptedException {
        Future<String> completableFuture =
                CompletableFuture.completedFuture("Hello");
        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    /**
     * 当我们使用future.get()方法阻止结果时，如果取消将来，它将抛出CancellationException：
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Test(expected = CancellationException.class)
   public void test_completable_cancel() throws InterruptedException, ExecutionException {
        CompletableFutureDemo completableFutureDemo=new CompletableFutureDemo();
        Future<String> future = completableFutureDemo.calculateAsyncWithCancellation();
        future.get(); // CancellationException
    }
    @Test
    public void test_supplyAsync() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "Hello");

        assertEquals("Hello", future.get());
    }
    @Test
    public void test_thenApply() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        assertEquals("Hello World", future.get());
    }
    @Test
    public void test_thenAccept() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));

       Assert.assertNull(future.get()); ;
    }
    @Test
    public void test_thenRun() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));

        Assert.assertNull(future.get()); ;
    }
    @Test
    public void test_thenCompose() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        assertEquals("Hello World", completableFuture.get());
    }
    CompletableFuture<Integer> computeAnother(Integer i){
        return CompletableFuture.supplyAsync(() -> 10 + i);
    }
    @Test
    public void test_thenCompose2() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> finalResult = CompletableFuture.supplyAsync(() -> 2).thenCompose(this::computeAnother);
        final int num = finalResult.get().intValue();
        Assert.assertEquals(num, 12);
    }

    @Test
    public void test_thenCombine() throws InterruptedException, ExecutionException {
    CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() -> "Hello")
            .thenCombine(CompletableFuture.supplyAsync(
                    () -> " World"), (s1, s2) -> s1 + s2);

    assertEquals("Hello World", completableFuture.get());
    }
    @Test
    public void test_thenAcceptBoth() throws InterruptedException, ExecutionException {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }
    @Test
    public void test_transform_result() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> finalResult = CompletableFuture.supplyAsync(() -> 1).thenApply(s -> s + 1);

        final int num = finalResult.get().intValue();
        Assert.assertEquals(num, 2);
    }
    @Test
    public void test_allOf() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

// ...



        assertTrue(future1.isDone());
        assertTrue(future2.isDone());
        assertTrue(future3.isDone());

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        assertEquals("Hello Beautiful World", combined);

    }
}