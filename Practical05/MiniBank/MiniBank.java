import java.util.Scanner;

public class MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== MiniBank =====");

        System.out.print("Enter savings account holder name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter savings opening balance: ");
        long s = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter current account holder name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter current opening balance: ");
        long c = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter fixed deposit holder name: ");
        String name3 = sc.nextLine();

        System.out.print("Enter fixed deposit amount: ");
        long f = sc.nextLong();

        Account[] accounts = {
            new SavingsAccount(name1, s, 1000),
            new CurrentAccount(name2, c, 2000),
            new FixedDepositAccount(name3, f)
        };

        System.out.println("\n===== Account Details =====");

        
        for (Account a : accounts) {
            System.out.println(a + " | Interest: "
                    + a.interestRate() + "%");
        }

        System.out.print("\nEnter withdrawal amount from savings: ");
        long amount = sc.nextLong();

        boolean success = accounts[0].withdraw(amount);

        System.out.println("Withdrawal successful: " + success);
        System.out.println("Updated savings balance: Rs."
                + accounts[0].getBalance());

        sc.close();
    }
}