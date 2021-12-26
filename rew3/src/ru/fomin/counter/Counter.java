package ru.fomin.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private Lock lock = new ReentrantLock();
    private long counter = 0L;

    public void increaseCounter() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    public long getCounter() {
        return counter;
    }

}
