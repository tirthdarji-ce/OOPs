
import java.util.Scanner;

public class DeadlockDemo {

    static final Object accountA = new Object();
    static final Object accountB = new Object();

    static void transferWithoutFix(boolean firstThread) {
        if (firstThread) {
            synchronized (accountA) {
                System.out.println("Thread 1 locked Account A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println("Thread 1 waiting for Account B");

                synchronized (accountB) {
                    System.out.println("Thread 1 transferred money");
                }
            }
        } else {
            synchronized (accountB) {
                System.out.println("Thread 2 locked Account B");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println("Thread 2 waiting for Account A");

                synchronized (accountA) {
                    System.out.println("Thread 2 transferred money");
                }
            }
        }
    }

    static void transferWithFix(String name) {
        synchronized (accountA) {
            System.out.println(name + " locked Account A");

            synchronized (accountB) {
                System.out.println(name + " locked Account B");
                System.out.println(name + " transferred money");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Demonstrate deadlock");
        System.out.println("2. Run fixed version");
        System.out.print("Choose mode: ");

        int choice = sc.nextInt();

        if (choice == 1) {
            Thread t1 = new Thread(
                () -> transferWithoutFix(true)
            );

            Thread t2 = new Thread(
                () -> transferWithoutFix(false)
            );

            // Set daemon BEFORE starting the threads
            t1.setDaemon(true);
            t2.setDaemon(true);

            t1.start();
            t2.start();

            t1.join(1000);
            t2.join(1000);

            if (t1.isAlive() && t2.isAlive()) {
                System.out.println("Deadlock detected: threads are blocked.");
            } else {
                System.out.println("Deadlock was not reproduced this time.");
            }

        } else if (choice == 2) {
            Thread t1 = new Thread(
                () -> transferWithFix("Thread 1")
            );

            Thread t2 = new Thread(
                () -> transferWithFix("Thread 2")
            );

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Completed without deadlock.");

        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
