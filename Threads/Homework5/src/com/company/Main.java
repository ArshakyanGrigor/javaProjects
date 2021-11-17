package com.company;


import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        CartesianSystem cartesianSystem = new CartesianSystem();
        Thread thread1 = null;
        Thread thread2 = null;
        for (int i = 0; i < 10; i++) {
            thread1 = new Thread(() -> {
                cartesianSystem.set(new AtomicInteger(1), new AtomicInteger(1));
                System.out.println("Thread 1");
            });
            thread2 = new Thread(() -> {
                cartesianSystem.set(new AtomicInteger(-1), new AtomicInteger(-1));
                System.out.println("Thread 2");
            });
            thread1.start();
            thread2.start();
        }
        cartesianSystem.toPrint();
    }
}