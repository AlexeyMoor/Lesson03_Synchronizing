package ait.elevator.task;

import ait.elevator.model.Elevator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Truck implements Runnable {
    private static final Lock mutex = new ReentrantLock();
    private final int nRaces;
    private final int capacity; // in kg
    private final Elevator elevator;

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }


    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            mutex.lock();
            try {
                elevator.add(capacity);
            } finally {
                mutex.unlock();
            }
        }
    }
}
