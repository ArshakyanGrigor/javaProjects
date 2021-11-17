package com.company;

public interface SimpleList<T> {
    void add(T item) throws InterruptedException;

    int getSize();

    T get(int index);


}
