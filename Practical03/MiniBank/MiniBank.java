
import java.util.Scanner;

public class MiniBank {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details for Account 1:");

        System.out.print("Account Number: ");
        String acc1 = sc.nextLine();

        System.out.print("Owner Name: ");
        String name1 = sc.nextLine();

        System.out.print("Balance: ");
        double bal1 = sc.nextDouble();
        sc.nextLine();

        Account account1 = new Account(acc1, name1, bal1);


        System.out.println("\nEnter details for Account 2:");

        System.out.print("Account Number: ");
        String acc2 = sc.nextLine();

        System.out.print("Owner Name: ");
        String name2 = sc.nextLine();

        System.out.print("Balance: ");
        double bal2 = sc.nextDouble();
        sc.nextLine();

        Account account2 = new Account(acc2, name2, bal2);
     
        System.out.println("\n--- Accounts ---");
        System.out.println(account1);
        System.out.println(account2);


        System.out.println("\n--- Comparison ---");
        System.out.println("Are accounts equal? " + account1.equals(account2));


        System.out.println("\n--- instanceof ---");
        Object obj = account1;

        if (obj instanceof Account) {
            System.out.println("Object is an Account.");
        }

 
        System.out.println("\n--- Customer ---");

        System.out.print("Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Mobile: ");
        String mobile = sc.nextLine();

        System.out.print("Address Line: ");
        String line = sc.nextLine();

        System.out.print("City: ");
        String city = sc.nextLine();

        System.out.print("Pincode: ");
        String pincode = sc.nextLine();

        Customer.Address address =
                new Customer.Address(line, city, pincode);

        Customer customer =
                new Customer(customerName, email, mobile, address);

        System.out.println("\nCustomer:");
        System.out.println(customer);

        // Clone
        Customer copy = customer.clone();

        System.out.println("\nCloned Customer:");
        System.out.println(copy);

        sc.close();
    }
}