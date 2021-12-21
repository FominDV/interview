package ru.fomin.example;

public abstract class Car implements Movable, Stoppable{

    private Engine engine;
    private String color;
    private String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    public abstract void open();

    @Override
    public void move() {
        System.out.println("car is moving");
    }

    @Override
    public void stop() {
        System.out.println("car is stop");
    }

    public void start() {
        System.out.println("car staring");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
