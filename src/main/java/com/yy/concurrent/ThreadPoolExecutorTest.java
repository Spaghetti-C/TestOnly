package com.yy.concurrent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
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
                System.out.println("添加任务 " + i);
                futures.add(
                        threadPoolExecutor.submit(() -> {
                            String printStr = Thread.currentThread().getName() + " task start at "
                                    + System.currentTimeMillis();
                            System.out.println(printStr);
                            try {
                                Thread.sleep(1000 + new Random().nextInt(10));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            printStr = Thread.currentThread().getName() + " task end at "
                                    + System.currentTimeMillis();
                            System.out.println(printStr);
                        })
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("start to get");
//        futures.forEach(future -> {
//            try {
//                future.isCancelled();
//                future.isDone();
//                future.get(1, TimeUnit.MILLISECONDS);
//            } catch (Exception e) {
//                System.out.println("异常！");
//                e.printStackTrace();
//            }
//        });

    }
}
