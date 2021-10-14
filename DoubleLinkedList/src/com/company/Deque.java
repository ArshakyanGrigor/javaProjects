package com.company;

public interface Deque {

    void addFirst(Integer element);

    void addLast(Integer element);

    void removeFirst();

    void removeLast();

    void push(Integer element);

    void pop(Integer value);

    boolean offerFirst(Integer element);

    boolean offerLast(Integer element);

    Integer pollFirst();

    Integer pollLast();
}