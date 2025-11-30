package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();

    private final int nRaces;
    private final int capacity; // in kg
    private final Elevator elevator1;
    private final Elevator elevator2;

    public Truck(int nRaces, int capacity, Elevator elevator1, Elevator elevator2) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator1 = elevator1;
        this.elevator2 = elevator2;
    }

    @Override
    public void run() {
        int halfCapacity = capacity / 2;

        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor1) {
                elevator1.add(halfCapacity);
            }
            synchronized (monitor2) {
                elevator2.add(halfCapacity);
            }
        }
    }
}
