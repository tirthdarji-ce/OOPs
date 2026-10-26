import java.util.Scanner;
import exception.BankException_8;
import exception.InsufficientFundsException_8;
import exception.InvalidAmountException_8;

public class Main_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter opening balance for Account 1: ");
            long firstBalance = input.nextLong();
            System.out.print("Enter opening balance for Account 2: ");
            long secondBalance = input.nextLong();

            if (firstBalance < 0 || secondBalance < 0) {
                System.out.println("Opening balances cannot be negative.");
                return;
            }


            Account_8 first = new Account_8(firstBalance);
            Account_8 second = new Account_8(secondBalance);

            try {
                System.out.print("Enter deposit amount for Account 1: ");
                first.deposit(input.nextLong());
                System.out.println("Deposit successful.");
            } catch (InvalidAmountException_8 e) {
                System.out.println("Deposit failed: " + e.getMessage());
            }

            try {
                System.out.print("Enter withdrawal amount from Account 1: ");
                first.withdraw(input.nextLong());
                System.out.println("Withdrawal successful.");
            } catch (InsufficientFundsException_8 e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
                System.out.println("Shortfall: " + e.getShortfall());
            } catch (InvalidAmountException_8 e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
            }

            try {
                System.out.print("Enter transfer amount from Account 1 to Account 2: ");
                first.transfer(second, input.nextLong());
            } catch (BankException_8 e) {
                System.out.println("Transfer failed: " + e.getMessage());
                if (e instanceof InsufficientFundsException_8) {
                    System.out.println("Shortfall: "
                        + ((InsufficientFundsException_8) e).getShortfall());
                }
            } finally {
                System.out.println("Transfer check completed.");
            }

            System.out.println("Account 1 balance: " + first.getBalance());
            System.out.println("Account 2 balance: " + second.getBalance());

            try (BankAccountSession_8 resource = new BankAccountSession_8()) {
                resource.use();
            } catch (Exception e) {
                System.out.println("Resource error: " + e.getMessage());
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Please enter valid whole numbers.");
        } finally {
            System.out.println("MiniBank program finished.");
            input.close();
        }
    }
}
