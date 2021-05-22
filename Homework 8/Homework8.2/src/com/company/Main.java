package com.company;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        System.out.println(store.getCountOfWorkers());
        System.out.println(store.getName());
        System.out.println(store.getPhoneNumber());
        System.out.println(store.getProductNumber());
        store.sellProduct();
        System.out.println(store.getProductNumber());
    }
}