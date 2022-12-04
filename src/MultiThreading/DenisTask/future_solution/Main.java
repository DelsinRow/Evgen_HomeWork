package MultiThreading.DenisTask.future_solution;

import java.util.concurrent.*;

public class Main {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            int taskNumber = i + 1;
            Future<Integer> task = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    increaseCount();
                    return count;
                }
            });

            int result = 0;
            try {
                result = task.get();              //get - дожидается окончания выполнения потока
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Task#" + taskNumber + " completed. Counter is " + count);
        }
        executorService.shutdown();

        System.out.println("\nCounter is " + count);
    }
    static synchronized void increaseCount() {
        int maxValue = 100_000_000;

        for (int i = 0; i < maxValue; i++) {
            count++;
        }
    }
}
