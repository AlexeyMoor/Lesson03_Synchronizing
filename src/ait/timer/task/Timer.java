package ait.timer.task;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer implements Runnable {
    private int clockPeriod = 3;


    public int getClockPeriod() {
        return clockPeriod;
    }

    public void setClockPeriod(int clockPeriod) {
        this.clockPeriod = clockPeriod;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(clockPeriod * 1000); // Может выбросить InterruptedException
            } catch (InterruptedException e) { // InterruptedException сбрасывает флаг прерывания потока при выбрасывании исключения
                // e.printStackTrace();
                System.out.println(Thread.currentThread().isInterrupted()); // false, потому что флаг прерывания сбрасывается при выбрасывании исключения
                System.out.println(Thread.interrupted());
                System.out.println(Thread.currentThread().getName() + " (aka Timer) say bye-bye!");
                break;
            }
        }
    }
}
