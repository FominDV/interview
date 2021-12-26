package ru.fomin.counter;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 300; i++) {
            new CounterThread(counter).start();
        }
        Thread.sleep(1000);
        System.out.println(counter.getCounter());
    }

}
