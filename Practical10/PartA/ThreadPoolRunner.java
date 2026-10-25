
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of tasks must be positive.");
            sc.close();
            return;
        }

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= n; i++) {
            final int id = i;

            pool.execute(() -> {
                System.out.println(
                    "Task " + id + " running on "
                    + Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task " + id + " was interrupted.");
                }
            });
        }

        pool.shutdown();

        try {
            if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All tasks finished.");
            } else {
                System.out.println("Tasks did not finish within the time limit.");
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

        sc.close();
    }
}
