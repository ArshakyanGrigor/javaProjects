package com.company;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        SimpleList<Integer> safeSimpleList = new SafeSimpleList<>();
        Thread thread = null;
        for (int i = 0; i < 20; i++) {
            thread = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        safeSimpleList.add(j);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.setName("A" + i);
        }

//        SimpleList<Integer> unsafeSimpleList = new UnsafeSimpleList<>();
//        Thread thread1 = null;
//        for (int t = 0; t < 20; t++) {
//            thread1 = new Thread(() -> {
//                try {
//                    for (int j = 0; j < 10; j++) {
//                        unsafeSimpleList.add(j);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            thread1.start();
//            thread1.setName("A" + t);
//        }
    }
}