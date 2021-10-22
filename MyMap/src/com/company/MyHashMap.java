package com.company;


public class MyHashMap implements Map {

    private int size;
    private int initialCapacity;
    private Node[] nodeArr;


    public MyHashMap() {
        this.initialCapacity = 16;
        this.nodeArr = new Node[initialCapacity];
    }

    public void put(String key, Integer value) {
        Node node1 = new Node(key, value);
        for (int i = 0; i < nodeArr.length; i++) {
            if (i == node1.hash) {
                if (nodeArr[i] != null) {
                    boolean isRepeat = true;
                    Node current = nodeArr[i];
                    while (current.next != null) {
                        if (current.Key == key) {
                            current.value = value;
                            isRepeat = false;
                            break;
                        }
                        current = current.next;
                    }
                    if (isRepeat) {
                        current.next = node1;
                        size++;
                    }
                } else {
                    nodeArr[i] = node1;
                    size++;
                }
                break;
            }
        }
    }

    public int get(String strKey) {
        int strH = strKey.hashCode() % 16;
        if (nodeArr[strH] != null) {
            if (strKey == nodeArr[strH].Key) {
                return nodeArr[strH].value;
            } else {
                Node current = nodeArr[strH];
                while (current.next != null) {
                    current = current.next;
                    if (strKey == current.Key) {
                        return current.value;
                    }
                }
            }
        }
        System.out.print(("Invalid key "));
        return -1;
    }

    public int remove(String strKey) {
        int strKeyHash = strKey.hashCode() % 16;
        int removeValue;
        if (nodeArr[strKeyHash] != null) {
            if (strKey == nodeArr[strKeyHash].Key) {
                removeValue = nodeArr[strKeyHash].value;
                if (nodeArr[strKeyHash].next != null) {
                    nodeArr[strKeyHash] = nodeArr[strKeyHash].next;
                    size--;
                    return removeValue;
                } else {
                    removeValue = nodeArr[strKeyHash].value;
                    nodeArr[strKeyHash] = null;
                    size--;
                    return removeValue;
                }
            }
            Node current = nodeArr[strKeyHash];
            while (current.next != null) {
                current = current.next;
                if (strKey == current.Key) {
                    removeValue = current.value;
                    size--;
                    return removeValue;
                }
            }
        }
        System.out.print("Invalid key ");
        return -1;
    }

    public int size() {
        return size;
    }
}
