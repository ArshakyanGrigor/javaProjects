package com.company;

public class SafeSimpleList<T> implements SimpleList<T> {
    private static final Integer DEFAULT_SIZE = 10000;
    private final Object[] array;
    private int size;

    public SafeSimpleList() {
        this.array = new Object[DEFAULT_SIZE];

    }

    @Override
    public synchronized void add(T item) {
        Thread t = Thread.currentThread();
        this.array[size] = item;
        size++;
        System.out.println(t.getName() + " " + item);
    }

    @Override
    public synchronized int getSize() {
        return size;
    }

    @Override
    public synchronized T get(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return (T) array[i];
            }
        }
        return null;
    }

    public void toPrint() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}