import java.util.Scanner;

public class TollBooth {

    record Vehicle(String number, String type) {}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {

            System.out.print("Enter vehicle number (or Done): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("Done")) {
                break;
            }

            System.out.print("Enter type (Bike/Car/Truck): ");
            String type = sc.next();

            Vehicle v = new Vehicle(number, type);

            int toll = 0;

            if (type.equalsIgnoreCase("Bike")) {
                toll = 20;
                bike++;
            }
            else if (type.equalsIgnoreCase("Car")) {
                toll = 50;
                car++;
            }
            else if (type.equalsIgnoreCase("Truck")) {
                toll = 150;
                truck++;
            }

            total = total + toll;

            System.out.println("Toll = " + toll);
        }

        String most;

        if (car >= bike && car >= truck) {
            most = "Car";
        }
        else if (bike >= truck) {
            most = "Bike";
        }
        else {
            most = "Truck";
        }

        System.out.println("\nTotal Toll = " + total);
        System.out.println("Most Frequent = " + most);

        sc.close();
    }
}

