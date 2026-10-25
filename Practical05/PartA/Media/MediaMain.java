import java.util.Scanner;

public class MediaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String book = sc.nextLine();

        System.out.print("Enter book late days: ");
        int bookDays = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter DVD title: ");
        String dvd = sc.nextLine();

        System.out.print("Enter DVD late days: ");
        int dvdDays = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter magazine title: ");
        String magazine = sc.nextLine();

        System.out.print("Enter magazine late days: ");
        int magazineDays = sc.nextInt();

        Media[] media = {
            new Book(book, bookDays),
            new DVD(dvd, dvdDays),
            new Magazine(magazine, magazineDays)
        };

        double total = 0;

        for (Media m : media) {
            double fee = m.lateFee();

            System.out.println("Late fee = " + fee);

            total += fee;
        }

        System.out.println("Total late fees = " + total);

        sc.close();
    }
}
