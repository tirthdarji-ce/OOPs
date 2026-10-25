import java.util.Scanner;

public class MainThermostat {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter location: ");
        String location = sc.nextLine();

        System.out.print("Enter starting temperature: ");
        int temperature = sc.nextInt();

        Thermostat t = new Thermostat(location, temperature);

        System.out.print("Enter number of raises: ");
        int raises = sc.nextInt();

        for (int i = 1; i <= raises; i++) {
            t.raise();
            System.out.println("Temperature = "
                    + t.getTemperature());
        }

        System.out.print("Enter number of lowers: ");
        int lowers = sc.nextInt();

        for (int i = 1; i <= lowers; i++) {
            t.lower();
            System.out.println("Temperature = "
                    + t.getTemperature());
        }

        System.out.println("Active Count = "
                + Thermostat.getActiveCount());

        sc.close();
    }
    
}