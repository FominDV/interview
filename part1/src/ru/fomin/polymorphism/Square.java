package ru.fomin.polymorphism;

public class Square extends Shape {

    protected Square(double length) {
        super(length);
    }

    @Override
    double calculateArea() {
        return Math.pow(getLength(),2);
    }

    @Override
    double calculatePerimeter() {
        return 4*getLength();
    }

    @Override
    String getName() {
        return "square";
    }

}
