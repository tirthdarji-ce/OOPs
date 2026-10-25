import java.util.Scanner;

public class CounterRace {

    static int counter = 0;

    static class Worker extends Thread {
        int times;

        Worker(int times) {
            this.times = times;
        }

        public void run() {
            for (int i = 0; i < times; i++) {
                counter++;
            }
        }
    }

    static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int threads = sc.nextInt();

        System.out.print("Enter increments per thread: ");
        int times = sc.nextInt();

      
        counter = 0;

        Thread[] workers = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            workers[i] = new Worker(times);
            workers[i].start();
        }

        for (Thread t : workers) {
            t.join();
        }

        System.out.println("Without synchronization: " + counter);
        System.out.println("Expected: " + (threads * times));

        
        counter = 0;

        for (int i = 0; i < threads; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    increment();
                }
            });
            workers[i].start();
        }

        for (Thread t : workers) {
            t.join();
        }

        System.out.println("With synchronization: " + counter);
    }
}