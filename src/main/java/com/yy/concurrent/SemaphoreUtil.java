package com.yy.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

/**
 * @author chenyiqin02
 * @date 2020/06/05
 */
public class SemaphoreUtil {

    public static <T> void runAsync(Consumer<T> consumer, T param, Semaphore semaphore, ExecutorService executorService) {
        acquireSemaphore(semaphore);
        executorService.submit(() -> process(consumer, param, semaphore));
    }

    public static <T> void process(Consumer<T> consumer, T param, Semaphore semaphore) {
        try {
            consumer.accept(param);
        } finally {
            semaphore.release();
        }
    }

    public static void acquireSemaphore(Semaphore semaphore) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
