package service;

import java.util.Scanner;
import model.Account;
import util.WithdrawRule;


import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        out.print("Enter account holder name: ");
        String name = sc.nextLine();

        out.print("Enter initial balance: ");
        long balance = sc.nextLong();

        out.print("Enter interest rate: ");
        double rate = sc.nextDouble();

        Account account = new Account(name, balance, rate);

        out.println("\n===== MiniBank =====");
        account.display();

        out.print("\nEnter deposit amount: ");
        long depositAmount = sc.nextLong();
        account.deposit(depositAmount);

        out.println("\n===== Anonymous Class =====");

        WithdrawRule rule1 = new WithdrawRule() {
            @Override
            public boolean allow(Account account, long amount) {
                return amount > 0 && amount <= account.getBalance();
            }
            
        };

        out.print("Enter withdrawal amount: ");
        long amount1 = sc.nextLong();

        if (rule1.allow(account, amount1)) {
            account.withdraw(amount1);
        } else {
            out.println("Withdrawal not allowed.");
        }

        out.println("\n===== Lambda Expression =====");

        WithdrawRule rule2 = (acc, amount) ->
                amount > 0 && amount <= acc.getBalance();

        out.print("Enter another withdrawal amount: ");
        long amount2 = sc.nextLong();

        if (rule2.allow(account, amount2)) {
            account.withdraw(amount2);
        } else {
            out.println("Withdrawal not allowed.");
        }

        out.println("\n===== Final Account Details =====");
        account.display();

        sc.close();
    }
}