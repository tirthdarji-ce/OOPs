import java.util.Scanner;

public class ParkingLotMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Two-wheeler capacity: ");
        int TwoCap = sc.nextInt();
           
        System.out.print("Enter Four-wheeler capacity: ");
        int FourCap = sc.nextInt();

        ParkingLot parking = new ParkingLot(TwoCap, FourCap);

        System.out.print("Enter number of parking events: ");
        int events = sc.nextInt();

        for (int i = 1; i <= events; i++) {

            System.out.print("Enter vehicle type (Two/Four): ");
            String type = sc.next();

            boolean result = parking.park(type);

            System.out.println("Parking result = " + result);
        }

        System.out.print("Enter vehicle type leaving (Two/Four): ");
        String leaveType = sc.next();

        parking.leave(leaveType);

        System.out.println("Two-wheelers = "
                + parking.getTwoWheelers());

        System.out.println("Four-wheelers = "
                + parking.getFourWheelers());

        System.out.println("Revenue = "
                + ParkingLot.getRevenue());

        sc.close();
    }
}
