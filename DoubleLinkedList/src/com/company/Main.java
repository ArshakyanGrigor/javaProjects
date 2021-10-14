package com.company;

public class Main {

    public static void main(String[] args) {
        MyDoubleLinkedList myLinkedList = new MyDoubleLinkedList();
        myLinkedList.addFirst(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(7);
        myLinkedList.addLast(3);
        myLinkedList.addFirst(4);
        myLinkedList.toPrint();

    }
}
