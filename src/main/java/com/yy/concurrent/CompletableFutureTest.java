package com.yy.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author chenyiqin02
 * @date 2020/01/16
 */
public class CompletableFutureTest {
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100), new ThreadFactoryBuilder().setNameFormat("thread-%d").build(),
            new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        completableFuture.complete("completableFuture complete");

        CompletableFuture.completedFuture("test");

        System.out.println("threadcount" + threadPoolExecutor.getActiveCount());

        CompletableFuture.supplyAsync(() -> {
            System.out.println("start");
            try {
                System.out.println("threadcount" + threadPoolExecutor.getActiveCount());
                Thread.sleep(5000);
                int i = 1 / 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }, threadPoolExecutor)
                .thenApply(r -> {
                    System.out.println("threadcount" + threadPoolExecutor.getActiveCount());
                    System.out.println("thenapply" + r);
                    return "111";
                })
                .whenComplete((r, e) -> {
                    System.out.println("threadcount" + threadPoolExecutor.getActiveCount());
                    System.out.println("whencomplete" + r);
                    System.out.println("complete");
                });
        System.out.println("out threadcount" + threadPoolExecutor.getActiveCount());
    }

    private static void FullUse() {

        CompletableFuture.supplyAsync(() -> {
            System.out.println("start");
            return "supplyAsync";
        }, threadPoolExecutor)
                .thenApply(r -> {
                    System.out.println(r);
                    return "thenApply";
                })
                .thenAccept(r -> {
                    System.out.println(r);
                })
                .thenRun(() -> System.out.println("thenRun"))
                .thenCombine(CompletableFuture.completedFuture("thenComBine"), (aVoid, s) -> {
                    System.out.println(s);
                    return "thenComBine";
                })
                .whenComplete((r, e) -> {
                    System.out.println(r);
                    System.out.println("complete");
                });
    }
}
