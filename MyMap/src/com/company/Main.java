package com.company;

public class Main {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("hkj", 21);
        myHashMap.put("hjkh", 98);
        myHashMap.put("Aram0", 19);
        myHashMap.put("hkj11", 648);
        myHashMap.put("hkj22", 53);
        myHashMap.put("hkj", 24);

        System.out.println(myHashMap.size());
        System.out.println(myHashMap.remove("hkj"));
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get("hkj"));

        String str = "hkj";
        String str2 = "hkj11";
        String str3 = "hkj22";
        System.out.println(str.hashCode() % 16);
        System.out.println(str2.hashCode() % 16);
        System.out.println(str3.hashCode() % 16);

    }
}

