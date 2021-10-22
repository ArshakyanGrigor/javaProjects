package com.company;

import java.util.Objects;

public class Node {

    public int hash;
    String Key;
    Integer value;
    Node next;

    public Node(String key, Integer value) {
        this.Key = key;
        this.value = value;
        this.hash = key.hashCode() % 16;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return hash == node.hash && Objects.equals(Key, node.Key) && Objects.equals(value, node.value) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, Key, value, next);
    }
}