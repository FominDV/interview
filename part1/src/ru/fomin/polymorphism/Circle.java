package ru.fomin.polymorphism;

public class Circle extends Shape {


    public Circle(int diameter) {
        super(diameter);
    }

    @Override
    double calculateArea() {
        return Math.pow(getLength(), 2) * Math.PI / 4.0;
    }

    @Override
    double calculatePerimeter() {
        return Math.PI * getLength();
    }

    @Override
    String getName() {
        return "circle";
    }

}
