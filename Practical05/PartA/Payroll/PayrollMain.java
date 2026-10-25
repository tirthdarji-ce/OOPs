import java.util.Scanner;

public class PayrollMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full-time name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter full-time ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter full-time salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter part-time name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter part-time ID: ");
        String id2 = sc.nextLine();

        System.out.print("Enter part-time hours: ");
        double hours = sc.nextDouble();

        System.out.print("Enter part-time rate: ");
        double rate = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter intern name: ");
        String name3 = sc.nextLine();

        System.out.print("Enter intern ID: ");
        String id3 = sc.nextLine();

        System.out.print("Enter intern stipend: ");
        double stipend = sc.nextDouble();

        Employee[] employees = {
            new FullTime(name1, id1, salary),
            new PartTime(name2, id2, hours, rate),
            new Intern(name3, id3, stipend)
        };

        double total = 0;

        for (Employee e : employees) {
            double amount = e.monthlySalary();

            System.out.println("Salary = " + amount);

            if (e instanceof Intern) {
                System.out.println("Note: This employee is an intern.");
            }

            total += amount;
        }

        System.out.println("Total payroll = " + total);

        sc.close();
    }
}
