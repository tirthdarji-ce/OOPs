
import java.util.Scanner;

public class SeatBooking {

    static int seatsLeft = 5;
    static int booked = 0;

    static boolean bookWithoutSync() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }

            seatsLeft--;
            booked++;
            return true;
        }
        return false;
    }

    static synchronized boolean book() {
        if (seatsLeft > 0) {
            seatsLeft--;
            booked++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of threads must be positive.");
            sc.close();
            return;
        }

        Thread[] threads = new Thread[n];

        // Without synchronization
        seatsLeft = 5;
        booked = 0;

        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(() -> {
                if (bookWithoutSync()) {
                    System.out.println("Booked (without sync)");
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\nWithout synchronization:");
        System.out.println("Total booked: " + booked);
        System.out.println("Seats left: " + seatsLeft);

        // With synchronization
        seatsLeft = 5;
        booked = 0;

        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(() -> {
                if (book()) {
                    System.out.println("Booked (with sync)");
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\nWith synchronization:");
        System.out.println("Total booked: " + booked);
        System.out.println("Seats left: " + seatsLeft);

        sc.close();
    }
}
