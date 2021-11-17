package com.company;

public class Main {

    public static void main(String[] args) {
        BlockA blockA = new BlockA();
        BlockB blockB = new BlockB();
        blockA.blockB = blockB;
        blockB.blockA = blockA;
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.blockA = blockA;
        myThread2.blockB = blockB;
        myThread1.start();
        myThread2.start();
    }

    static class MyThread1 extends Thread {
        BlockA blockA;

        @Override
        public void run() {
            blockA.blockMethodA();
        }
    }

    static class MyThread2 extends Thread {
        BlockB blockB;

        @Override
        public void run() {
            blockB.blockMethodB();
        }
    }

    static class BlockA {
        BlockB blockB;

        public synchronized void blockMethodA() {
            System.out.println("Block A");
            Sleeping.sleep(1000);
            blockB.endBlockMethodB();

        }

        public synchronized void endBlockMethodA() {
            System.out.println("End block A");
        }
    }

    static class BlockB {
        BlockA blockA;

        public synchronized void blockMethodB() {
            System.out.println("Block B");
            Sleeping.sleep(1000);
            blockA.endBlockMethodA();
        }

        public synchronized void endBlockMethodB() {
            System.out.println("End block B");
        }
    }

    static class Sleeping {
        static void sleep(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}