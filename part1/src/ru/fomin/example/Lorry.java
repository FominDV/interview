package ru.fomin.example;

public class Lorry extends Car {

    private static final String NAME = "Lorry";

    public Lorry(Engine engine, String color) {
        super(engine, color, NAME);
    }

    @Override
    public void open() {
        System.out.println("car is open");
    }

}
