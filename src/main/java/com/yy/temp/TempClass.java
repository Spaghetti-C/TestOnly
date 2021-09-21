package com.yy.temp;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
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
        P p1 = new P();
        P p2 = new P();

        new Thread(
                () -> p1.fun2()
        ).start();
        new Thread(
                () -> p2.fun2()
        ).start();
    }

}

class P {
    synchronized void fun()  {
        System.out.println(Thread.currentThread().getId());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    void fun2() {
        // dos th

        synchronized (P.class) {
            // do sth
            System.out.println(Thread.currentThread().getId());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("done");
        }
    }

    void fun3() {
        // dos th

        synchronized (this) {
            // do sth
            System.out.println(Thread.currentThread().getId());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("done");
        }
    }
}

