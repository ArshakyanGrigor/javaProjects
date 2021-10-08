package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(4);
        myLinkedList.add(6);
        myLinkedList.add(9);
        myLinkedList.add(5);
        System.out.println(myLinkedList.size());
        myLinkedList.removeIndex(0);
        System.out.println(myLinkedList.size());
        myLinkedList.toPrint();

    }
}