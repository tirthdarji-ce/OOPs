import java.util.Scanner;

public class Main__9 {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int threadCount = input.nextInt();

        System.out.print("Enter deposits per thread: ");
        int times = input.nextInt();

        System.out.print("Enter amount per deposit: ");
        long amount = input.nextLong();

        if (threadCount <= 0 || times <= 0 || amount < 0) {
            System.out.println("Please enter a positive thread count and deposit count, and a non-negative amount.");
            input.close();
            return;
        }

        Account__9 account = new Account__9();
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            AccountWorker__9 worker = new AccountWorker__9(account, times, amount);
            threads[i] = new Thread(worker, "Worker-" + (i + 1));
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }

        long expectedBalance = (long) threadCount * times * amount;
        System.out.println("\nFinal Balance: " + account.getBalance());
        System.out.println("Expected Balance: " + expectedBalance);

        input.close();
    }
}
