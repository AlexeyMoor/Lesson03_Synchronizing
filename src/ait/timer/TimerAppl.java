package ait.timer;

import ait.timer.task.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimerAppl {
    static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        // thread.setDaemon(true); // До старта, чтобы поток завершился при завершении основного потока программы
        thread.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter clock period in seconds, or type 'q' to quit:");
            String str = br.readLine();
            if ("q".equalsIgnoreCase(str)) {
                thread.interrupt(); // Меняет флаг прерывания потока thread на true
                System.out.println("In main thread: " + thread.isInterrupted());
                break;
            } else {
                timer.setClockPeriod(Integer.parseInt(str));
            }
        }
        System.out.println(Thread.currentThread().getName() + " thread is finished");
    }
}
