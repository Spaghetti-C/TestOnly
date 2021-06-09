package com.yy.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyiqin02
 * @date 2020/02/13
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool joinPool = new ForkJoinPool();
        joinPool.submit(new PrintTask(0, 20));
        joinPool.awaitQuiescence(3, TimeUnit.SECONDS);
        joinPool.shutdown();
    }

    static class PrintTask extends RecursiveAction {
        private static final int THRESHOLD = 5;
        private int start, end;

        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < THRESHOLD) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + "的i值: " + i);
                }
                return;
            }
            int mid = (start + end) >> 1;
            PrintTask left = new PrintTask(start, mid);
            PrintTask right = new PrintTask(mid, end);
            left.fork();
            right.fork();
        }
    }
}
