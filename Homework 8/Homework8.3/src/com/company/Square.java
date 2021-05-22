package com.company;

public class Square extends Shape{

    public Square(double radius) {
        this.radius = radius;
    }

    @Override
    public void getArea() {
        System.out.println(radius * radius);
    }

    @Override
    public void getPerimeter() {
        System.out.println(4 * radius);
    }
}