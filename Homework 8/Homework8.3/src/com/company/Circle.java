package com.company;

public class Circle extends Shape {

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void getArea() {
        System.out.println(radius * radius * Math.PI);
    }

    @Override
    public void getPerimeter() {
        System.out.println(2 * radius * Math.PI);
    }
}
