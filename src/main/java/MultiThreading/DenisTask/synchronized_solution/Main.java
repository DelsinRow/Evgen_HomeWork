package MultiThreading.DenisTask.synchronized_solution;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CounterThread counter = new CounterThread();

        Thread firstThread = new Thread(counter, "First");
        Thread secondThread = new Thread(counter, "Second");
        Thread thirdThread = new Thread(counter, "Third");

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();

        System.out.println("Counter is " + counter.getCount());
    }
}
