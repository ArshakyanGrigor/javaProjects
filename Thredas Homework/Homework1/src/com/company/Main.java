package com.company;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int number = 10000000;
        AtomicLong sumOfOne = new AtomicLong();
        AtomicLong sumOfTwo = new AtomicLong();
        Thread thread = new Thread(() -> {
            long sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            System.out.println(sum);
        });
        thread.start();
        thread.join();
        System.out.println((System.currentTimeMillis() - start));

        Thread thread1 = new Thread(() -> {
            System.out.println("thread 1 start");
            for (int i = 1; i < number / 2; i++) {
                sumOfOne.addAndGet(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread 2 start");
            for (int i = number; i >= number / 2; i--) {
                sumOfTwo.addAndGet(i);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(sumOfOne.addAndGet(sumOfTwo.get()));
        System.out.println((System.currentTimeMillis() - start));
    }
}