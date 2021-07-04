package com.yy.algorithm.daily;

public class ConcurrentPrintNum {
    public static volatile int num = 0;

    public static void main(String[] args) {
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        threadA.start();
        threadB.start();
    }

    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (num < 10) {
                if (num % 2 == 0) {
                    System.out.println(num);
                    num++;
                }
            }
        }
    }
    public static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (num < 10) {
                if (num % 2 == 1) {
                    System.out.println(num);
                    num++;
                }
            }
        }
    }

}
