package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person("aga", "martiros", 19, "male", "AN098098");
        person.printInfo();

    }
}
