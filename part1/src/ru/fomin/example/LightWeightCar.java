package ru.fomin.example;

public class LightWeightCar extends Car {

    private static final String NAME = "Light weight car";

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, NAME);
    }

    @Override
    public void open() {
        System.out.println("car is open");
    }

}
