package com.company;

public class Main {

    public static void main(String[] args) {

        // Bubble sort
        int[] arr = new int[]{20, 10, 15, 54, 231, 1, 9, 5};

        for (int i = 0; i < arr.length - 1; i++) {
            int temp;
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


        // Insertion sort
        int[] arr1 = {124, 33, 27, 10, 213, 19, 42, 44};

        for (int i = 1; i < arr1.length; i++) {
            int key = arr1[i];
            int j = i - 1;
            while (j >= 0 && arr1[j] > key) {
                arr1[j + 1] = arr1[j];
                j = j - 1;
            }
            arr1[j + 1] = key;
        }
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
