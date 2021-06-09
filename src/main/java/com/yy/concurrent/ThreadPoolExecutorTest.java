package com.yy.concurrent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyiqin02
 * @date 2020/01/08
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future> futures = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            try {
                futures.add(
                        threadPoolExecutor.submit(() -> {
                            System.out.println("task start");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("task end");
                        })
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("start to get");
        futures.forEach(future -> {
            try {
                future.isCancelled();
                future.isDone();
                future.get(1, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                System.out.println("异常！");
                e.printStackTrace();
            }
        });

    }
}
