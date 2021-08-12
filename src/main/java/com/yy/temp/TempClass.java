package com.yy.temp;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用于简单快速测试
 *
 * @author chenyiqin02
 * @date 2020/04/28
 */
@Builder
@Data
@Slf4j
public class TempClass {

    public static void main(String[] args) {
        ExecutorService servie = new ThreadPoolExecutor(2, 4, 0, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 10; i++) {
            servie.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
    }
}

