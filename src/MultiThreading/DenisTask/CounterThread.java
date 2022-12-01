package MultiThreading.DenisTask;

public class CounterThread extends Thread {
    private int count = 0;

public int getCount() {
    return count;
}

    @Override
    public void run() {
        increaseCount();
        System.out.println(Thread.currentThread().getName() + " thread finished. Count is " + count);
    }

    public synchronized void increaseCount() {
        int maxValue = 100_000_000;

        for (int i = 0; i < maxValue; i++) {
            count++;
        }
    }
}
