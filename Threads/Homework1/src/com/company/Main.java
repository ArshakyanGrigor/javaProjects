package com.company;

import java.util.concurrent.Callable;


public class Main {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int number = 10000000;
        Thread thread = new Thread(() -> {
            long sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            System.out.println("Sum with one thread " + sum);
        });
        thread.start();
        thread.join();
        System.out.println((System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();
        MyThread1 myThread1 = new MyThread1(number);
        MyThread2 myThread2 = new MyThread2(number);
        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();
        long sum = myThread1.getSumOfOne() + myThread2.getSumOfTwo();
        System.out.println("Sum with two thread " + sum);
        System.out.println((System.currentTimeMillis() - start1));

    }
}

class MyThread1 extends Thread {
    private final long number;
    private long sumOfOne;

    MyThread1(long number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i < number / 2; i++) {
            sumOfOne += i;
        }
    }

    public long getSumOfOne() {
        return sumOfOne;
    }
}

class MyThread2 extends Thread {
    private final long number;
    private long sumOfTwo;

    MyThread2(long number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (long i = number; i >= number / 2; i--) {
            sumOfTwo += i;
        }
    }

    public long getSumOfTwo() {
        return sumOfTwo;
    }
}