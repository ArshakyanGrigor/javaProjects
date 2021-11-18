package com.company;

public class UnsafeSimpleList<T> implements SimpleList<T> {
    private static final Integer DEFAULT_SIZE = 10000;
    private final Object[] UnsafeArray;
    private int size;


    public UnsafeSimpleList() {
        this.UnsafeArray = new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T item) {
        Thread t = Thread.currentThread();
        this.UnsafeArray[size] = item;
        size++;
        System.out.println(t.getName() + " " + item);
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public T get(int index) {
        for (int i = 0; i < UnsafeArray.length; i++) {
            if (i == index) {
                return (T) UnsafeArray[i];
            }
        }
        return null;
    }
}
