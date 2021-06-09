package com.yy.reentrantlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author chenyiqin02
 * @date 2019/06/03
 */
public class Demo {
    static int count = 0;
    static CyclicBarrier barrier = new CyclicBarrier(11);

    public static void main(String[] args) throws InterruptedException {
        conditionTest();
//        fairAndUnfairTest();
    }

    private static void conditionTest() {
        System.out.println("main start");
        Lock unfairLock = new ReentrantLock();
        Lock fairLock = new ReentrantLock(true);
        Condition condition = unfairLock.newCondition();

        //常规写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                awaitMethod(unfairLock, condition);
            }
        }, "thread1").start();
        //lambda写法
        new Thread(() -> signalMethod(unfairLock, condition), "thread2").start();

        System.out.println("main finish");
    }


    private static void fairAndUnfairTest() {
        Lock unfairLock = new ReentrantLock();
        Lock fairLock = new ReentrantLock(true);
        long now = System.nanoTime();
        Thread thread = null;
        try {
            for (int i = 0; i < 10; i++) {
                thread = new Thread(() -> lockMethod(unfairLock), "threadUnfair");
                thread.start();
            }
            barrier.await();
            System.out.println("unfair cost time:" + (System.nanoTime() - now));

            barrier.reset();
            now = System.nanoTime();
            for (int i = 0; i < 10; i++) {
                thread = new Thread(() -> lockMethod(fairLock), "threadFair");
                thread.start();
            }
            barrier.await();
            System.out.println("  fair cost time:" + (System.nanoTime() - now));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void awaitMethod(Lock lock, Condition condition) {
        lock.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("ThreadName:" + Thread.currentThread().getName()
                        + (" i=" + i));
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void signalMethod(Lock lock, Condition condition) {
        lock.lock();
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("ThreadName:" + Thread.currentThread().getName()
                        + (" i=" + i));
                condition.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static void lockMethod(Lock lock) {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
