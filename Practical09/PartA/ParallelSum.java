
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ParallelSum {


    static long sharedTotal = 0;

    static class Worker extends Thread {
        int[] arr;
        int start, end;

        Worker(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                sharedTotal += arr[i]; // Not synchronized
            }
        }
    }

    static class SyncWorker extends Thread {
        int[] arr;
        int start, end;

        SyncWorker(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                synchronized (ParallelSum.class) {
                    sharedTotal += arr[i];
                }
            }
        }
    }

    static class LocalWorker extends Thread {
        int[] arr;
        int start, end;
        long localTotal = 0;

        LocalWorker(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                localTotal += arr[i];
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Array size must be positive.");
            sc.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of threads: ");
        int threadCount = sc.nextInt();

        if (threadCount <= 0) {
            System.out.println("Thread count must be positive.");
            sc.close();
            return;
        }

        long expected = 0;
        for (int value : arr) {
            expected += value;
        }

        Thread[] threads = new Thread[threadCount];
        int chunk = (n + threadCount - 1) / threadCount;

        // 1. Shared total without synchronization
        sharedTotal = 0;
        long startTime = System.nanoTime();

        for (int t = 0; t < threadCount; t++) {
            int start = t * chunk;
            int end = Math.min(start + chunk, n);

            threads[t] = new Worker(arr, start, end);
            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long unsyncTime = System.nanoTime() - startTime;

        System.out.println("\nWithout synchronization:");
        System.out.println("Total = " + sharedTotal);
        System.out.println("Correct total = " + expected);
        System.out.println("Time = " + unsyncTime + " ns");

        // 2. Shared total with synchronization
        sharedTotal = 0;
        startTime = System.nanoTime();

        for (int t = 0; t < threadCount; t++) {
            int start = t * chunk;
            int end = Math.min(start + chunk, n);

            threads[t] = new SyncWorker(arr, start, end);
            threads[t].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long syncTime = System.nanoTime() - startTime;

        System.out.println("\nWith synchronization:");
        System.out.println("Total = " + sharedTotal);
        System.out.println("Time = " + syncTime + " ns");

        // 3. Each thread calculates a local total
        LocalWorker[] localWorkers = new LocalWorker[threadCount];
        startTime = System.nanoTime();

        for (int t = 0; t < threadCount; t++) {
            int start = t * chunk;
            int end = Math.min(start + chunk, n);

            localWorkers[t] = new LocalWorker(arr, start, end);
            localWorkers[t].start();
        }

        long localTotal = 0;
        for (LocalWorker worker : localWorkers) {
            worker.join();
            localTotal += worker.localTotal;
        }

        long localTime = System.nanoTime() - startTime;

        System.out.println("\nWith local totals:");
        System.out.println("Total = " + localTotal);
        System.out.println("Time = " + localTime + " ns");

        sc.close();
    }
}
