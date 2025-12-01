package ait.volatiles.task;

public class InfiniteLoop implements Runnable {
    private volatile boolean flag = true; // volatile для обеспечения видимости изменений между потоками

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (isFlag()) {
            // бесконечный цикл
        }
        System.out.println(Thread.currentThread().getName() + " - finished");
    }
}
