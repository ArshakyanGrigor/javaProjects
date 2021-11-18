package com.company;

import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        int size = 10;
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                Integer number = i;
                list.add(number);
                System.out.println("Thread1 added");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                Integer number = i;
                list.add(number);
                System.out.println("Thread2 added");
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                if(!list.isEmpty()) {
                    list.remove(0);
                    System.out.println("Thread3 removed");
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(list.size());
    }
}