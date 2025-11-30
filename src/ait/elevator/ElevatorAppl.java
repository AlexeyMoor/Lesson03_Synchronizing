package ait.elevator;

import ait.elevator.model.Elevator;
import ait.elevator.task.Truck;

public class ElevatorAppl {
    private static final int N_TRUCKS = 10_000;
    private static final int N_RACES = 10;
    private static final int CAPACITY = 20; // in kg

    static void main(String[] args) throws InterruptedException {
        Elevator elevator1 = new Elevator("'V.I.Lenin'");
        Elevator elevator2 = new Elevator("'I.V.Stalin'");

        Truck[] trucks = new Truck[N_TRUCKS];
        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(N_RACES, CAPACITY, elevator1, elevator2);
        }
        Thread[] threads = new Thread[trucks.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(trucks[i]);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Elevator 1: " + elevator1.getName() + " has " + elevator1.getCurrentVolume() + " kg");
        System.out.println("Elevator 2: " + elevator2.getName() + " has " + elevator2.getCurrentVolume() + " kg");
        System.out.println("Total: " + (elevator1.getCurrentVolume() + elevator2.getCurrentVolume()) + " kg");
    }
}
