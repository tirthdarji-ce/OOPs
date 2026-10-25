package model;

import model.InterestBearing;

import model.Premium;
import model.Transactable;

public class Account implements Transactable, InterestBearing, Premium {
    private final String holderName;
    private long balance;
    private final double rate;

    public Account(String holderName, long balance, double rate) {
        this.holderName = holderName;
        this.balance = balance;
        this.rate = rate;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public double interestRate() {
        return rate;
    }

    @Override
    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public boolean withdraw(long amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Withdrawal failed.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        return true;
    }

    public void display() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Yearly Interest: " + yearlyInterest());
    }
}
