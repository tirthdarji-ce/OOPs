import java.util.Scanner;

public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }
    public CinemaShow(String title) { this(title, 100); }

    public boolean book(int n) {
        if (n <= 0 || n > seatsAvailable) return false;
        seatsAvailable -= n;
        totalBooked += n;
        return true;
    }
    public void cancel(int n) {
        if (n > 0) seatsAvailable = Math.min(capacity, seatsAvailable + n);
    }
    public int getSeatsAvailable() { return seatsAvailable; }
    public static int getTotalBooked() { return totalBooked; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Movie title: "); String title = sc.nextLine();
        System.out.print("Capacity: "); int cap = sc.nextInt();
        CinemaShow show = new CinemaShow(title, cap);

        System.out.print("Seats to book: "); int book = sc.nextInt();
        System.out.println("Booking result: " + show.book(book));
        System.out.println("Seats left: " + show.getSeatsAvailable());

        System.out.print("Seats to cancel: "); int cancel = sc.nextInt();
        show.cancel(cancel);
        System.out.println("Seats left: " + show.getSeatsAvailable());
        System.out.println("Total successfully booked: " + getTotalBooked());
    }
}
