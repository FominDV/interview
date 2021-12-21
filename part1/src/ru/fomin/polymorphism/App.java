package ru.fomin.polymorphism;

public class App {

    public static void main(String[] args) {
        printShapeData(new Circle(2));
        printShapeData(new Square(2));
        printShapeData(new Rectangle(2, 3));
    }

    private static void printShapeData(Shape shape) {
        System.out.printf(
                "Shape: \"%s\"\nArea: %.2f\nPerimeter: %.2f\n\n",
                shape.getName(),
                shape.calculateArea(),
                shape.calculatePerimeter());
    }

}
