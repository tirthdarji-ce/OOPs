package modell;
import model.InterestBearing;
import model.Premium;
import model.Transactable;
import modell.annotation.Id;
import modell.annotation.MaxLength;
import modell.annotation.Positive;

public class Accountt implements Transactable, InterestBearing, Premium {
    @Id
    @MaxLength(20)
    private String accountNumber;

    @MaxLength(50)
    private String holderName;

    @Positive
    private long balance;

    private double rate;

    public Accountt(String accountNumber, String holderName, long balance, double rate) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.rate = rate;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }

    @Override
    public long getBalance() { return balance; }

    @Override
    public double interestRate() { return rate; }

    @Override
    public void deposit(long amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
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
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Yearly Interest: " + yearlyInterest());
    }

    @Override
    public String toString() {
        return accountNumber + " - " + holderName + " - Balance: " + balance;
    }
}
