package com.yy.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

/**
 * @author chenyiqin02
 * @date 2020/06/05
 */
public class SemaphoreUtilTest {
    @Test
    public void test() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new SynchronousQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 1000; i++) {
            SemaphoreUtil.runAsync(param -> {
                try {
                    System.out.println(param);
                    Thread.sleep(param * 1000);
                    System.out.println("complete" + param);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }, i, semaphore, executorService);
        }
    }

}