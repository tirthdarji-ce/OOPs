import java.util.Scanner;

public class MiniBank {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account[] accounts = new Account[3];


        for (int i = 0; i < 3; i++) {

            System.out.println("\nCustomer " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter mobile: ");
            String mobile = sc.nextLine();

            Customer customer = new Customer(name, email, mobile);

            System.out.print("Enter opening balance: ");
            long balance = sc.nextLong();
            sc.nextLine();

            accounts[i] = new Account(customer.getName(), balance);

            System.out.println("Customer ID: "
                    + customer.getCustomerId());

            System.out.println("Account Number: "
                    + accounts[i].getAccountNumber());
        }

        for (int i = 0; i < 3; i++) {

            System.out.print("\nEnter deposit for "
                    + accounts[i].getOwnerName() + ": ");

            long amount = sc.nextLong();

            accounts[i].deposit(amount);
        }

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter withdrawal for "
                    + accounts[i].getOwnerName() + ": ");

            long amount = sc.nextLong();

            boolean result = accounts[i].withdraw(amount);

            System.out.println("Withdraw successful: " + result);
        }

        System.out.println("\n--- ACCOUNT DETAILS ---");

        for (int i = 0; i < 3; i++) {

            System.out.println("Account Number: "
                    + accounts[i].getAccountNumber());

            System.out.println("Owner Name: "
                    + accounts[i].getOwnerName());

            System.out.println("Balance: "
                    + accounts[i].getBalance());

            System.out.println("Active: "
                    + accounts[i].isActive());

            System.out.println();
        }

        sc.close();
    }
}