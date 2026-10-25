import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.next();

        MiniBank bank = new MiniBank(name);

        while (true) {

            System.out.println("\n===== MiniBank =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Show Balance");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount: ");
                bank.deposit(sc.nextInt());

            } else if (choice == 2) {
                System.out.print("Enter amount: ");
                bank.withdraw(sc.nextInt());

            } else if (choice == 3) {
                System.out.print("Enter amount: ");
                bank.transfer(sc.nextInt());

            } else if (choice == 4) {
                bank.showBalance();

            } else if (choice == 5) {
                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
    
}