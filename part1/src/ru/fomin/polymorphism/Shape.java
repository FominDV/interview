package ru.fomin.polymorphism;

public abstract class Shape {

    private double length;

    protected Shape(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    abstract double calculateArea();

    abstract double calculatePerimeter();

    abstract String getName();

}
