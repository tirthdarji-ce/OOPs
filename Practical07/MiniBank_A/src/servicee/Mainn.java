package servicee;
import java.util.Scanner;

import modell.Accountt;
import utill.Withdraw;

import static java.lang.System.out;

public class Mainn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        out.print("Enter account holder name: ");
        String holderName = sc.nextLine();

        out.print("Enter balance: ");
        long balance = Long.parseLong(sc.nextLine());

        out.print("Enter interest rate: ");
        double rate = Double.parseDouble(sc.nextLine());

        Accountt account = new Accountt(accountNumber, holderName, balance, rate);

        out.println("\n===== Account Details =====");
        account.display();

        out.println("\n===== Annotation Validation =====");
        String[] errors = AnnotationValidator.validate(account);
        if (errors.length == 0) {
            out.println("Account is valid.");
        } else {
            for (String error : errors) out.println(error);
        }

        Withdraw rule = (acc, amount) ->
                amount > 0 && amount <= acc.getBalance();

        out.print("\nEnter withdrawal amount to check: ");
        long amount = Long.parseLong(sc.nextLine());
        out.println(rule.allow(account, amount)
                ? "Withdrawal is allowed."
                : "Withdrawal is not allowed.");

        sc.close();
    }
}
