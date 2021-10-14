package com.company;

import java.util.NoSuchElementException;

public class MyDoubleLinkedList implements Deque {

    private Node first;
    private Node last;
    private int size;

    public void addFront(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            node.setNext(first);
            node.setPrev(null);
            first.setPrev(node);
            first = node;
            size++;
        }
    }

    public void addEnd(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
            size++;
        } else {
            Node current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setPrev(current);
            last = node;
            size++;
        }
    }

    public Object get(Integer index) {
        if (first == null) {
            throw new IllegalArgumentException("Linked list is empty");
        }
        Node temp = first;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.getValue();
            }
            count++;
            temp = temp.getNext();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean removeFromFront(Integer value) {
        if (first == null) {
            return false;
        }
        if (first.getValue().equals(value)) {
            if (first.getNext() != null) {
                first.getNext().setPrev(null);
                first = first.getNext();
                size--;
                return true;
            }
            first = null;
            last = null;
            size--;
            return true;
        }
        Node current = first;
        while (current.getNext() != null) {
            current = current.getNext();
            if (current.getValue().equals(value)) {
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    last = current.getPrev();
                }
                current.getPrev().setNext(current.getNext());
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean removeFromEnd(Integer value) {
        if (last == null) {
            return false;
        }
        if (last.getValue().equals(value)) {
            if (last.getPrev() != null) {
                last.getPrev().setNext(null);
                last = last.getPrev();
                size--;
                return true;
            }
            first = null;
            last = null;
            size--;
            return true;
        }
        Node current = last;
        while (current.getPrev() != null) {
            current = current.getPrev();
            if (current.getValue().equals(value)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    first = current.getNext();
                }
                current.getNext().setPrev(current.getPrev());
                size--;
                return true;
            }

        }
        return false;
    }


    public void toPrint() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    @Override
    public void addFirst(Integer element) {
        addFront(element);
    }

    @Override
    public void addLast(Integer element) {
        addEnd(element);
    }

    @Override
    public void removeFirst() {
        if (first == null || first.getNext() == null) {
            first = null;
            return;
        }
        first = first.getNext();
        first.setPrev(null);
    }

    @Override
    public void removeLast() {
        if (first == null || first.getNext() == null) {
            first = null;
            return;
        }
        last = last.getPrev();
        last.setNext(null);
    }

    @Override
    public void push(Integer element) {
        addFront(element);
    }

    @Override
    public void pop(Integer element) {
        removeFromFront(element);
    }

    @Override
    public boolean offerFirst(Integer element) {
        removeFromFront(element);
        return false;
    }

    @Override
    public boolean offerLast(Integer element) {
        removeFromEnd(element);
        return false;
    }

    @Override
    public Integer pollFirst() {
        Node temp = first;
        if (first == null) {
            return null;
        }
        if (first.getNext() == null) {
            first = null;
            return temp.getValue();
        }
        first = first.getNext();
        first.setPrev(null);
        return temp.getValue();
    }

    @Override
    public Integer pollLast() {
        Node temp = last;
        if (first == null) {
            return null;
        }
        if (first.getNext() == null) {
            first = null;
            return temp.getValue();
        }
        last = last.getPrev();
        last.setNext(null);
        return temp.getValue();
    }
}