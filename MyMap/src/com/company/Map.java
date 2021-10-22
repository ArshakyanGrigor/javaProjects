package com.company;

public interface Map {

    void put(String key, Integer value);

    int remove(String key);

    int size();

    int get(String key);
}
