
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionProcessor_10 {
    private ExecutorService executor = Executors.newFixedThreadPool(3);

    public void submit(Runnable task) {
        executor.submit(task);
    }

    public void stop() throws InterruptedException {
        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }
    }
}
