package ru.fomin.polymorphism;

public class Rectangle extends Shape {

    private double width;

    protected Rectangle(double length, double width) {
        super(length);
        this.width = width;
    }

    @Override
    double calculateArea() {
        return getLength() * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (getLength() + width);
    }

    @Override
    String getName() {
        return "rectangle";
    }

    public double getWidth() {
        return width;
    }

}
