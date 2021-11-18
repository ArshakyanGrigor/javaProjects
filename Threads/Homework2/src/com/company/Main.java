package com.company;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        Files filesCreate = new Files(new CountDownLatch(10));
        filesCreate.start();
//        Files filesCreate = null;
//        for (int i = 0; i < 10; i++) {
//            filesCreate = new Files(new CountDownLatch(1));
//            filesCreate.start();
//        }
        filesCreate.join();
        System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000);
    }

}