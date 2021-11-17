package com.company;


import java.util.concurrent.atomic.AtomicInteger;

public class CartesianSystem {
    public AtomicInteger x;
    public AtomicInteger y;

    CartesianSystem() {
    }

    public void set(AtomicInteger x, AtomicInteger y) {
        this.x = x;
        this.y = y;
    }

    public void toPrint() {
        System.out.println(x + " " + y);
    }
}