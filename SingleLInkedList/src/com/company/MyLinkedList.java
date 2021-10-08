package com.company;

public class MyLinkedList {

    Node first;
    Node last;
    int size;


    public Integer get(int index) {
        Node current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public void add(Integer value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            last.next = node;
            last = node;
            size++;
        }
    }


    public boolean remove(Integer value) {
        if (first == null) {
            return false;
        }
        if (first.value.equals(value)) {
            first = first.next;
            size--;
            return true;
        }
        Node current = first;
        while (current.next != null) {
            Node temp = current;
            current = current.next;
            if (current.value.equals(value)) {
                temp.next = current.next;
                size--;
                return true;
            }
        }
        return false;
    }

    public void removeIndex(int index) {
        if (first == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        if (index == 0) {
            first = first.next;
            size--;
            return;
        }
        Node current = first;
        int count = 1;
        while (current.next != null) {
            Node temp = current;
            current = current.next;
            if (count == index) {
                temp.next = current.next;
                size--;
                return;
            }
            count++;
        }
        System.out.println();
    }


    public int size() {
        return size;
    }

    boolean contains(Integer value) {
        Node temp = first;
        while (temp != null) {
            if (temp.value.equals(value)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void toPrint() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }
}