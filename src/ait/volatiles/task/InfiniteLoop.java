package ait.volatiles.task;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.reflect.Array.set;

public class InfiniteLoop implements Runnable {
    private AtomicBoolean flag = new AtomicBoolean(true);

    public boolean isFlag() {
        return flag.get();
    }

    public void setFlag(boolean flag) {
        this.flag.set(flag);
    }

    @Override
    public void run() {
        while (isFlag()) {
            // бесконечный цикл
        }
        System.out.println(Thread.currentThread().getName() + " - finished");
    }
}
