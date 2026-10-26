import exception.AccountNotFoundException_8;
import exception.BankException_8;
import exception.InsufficientFundsException_8;
import exception.InvalidAmountException_8;


public class Account_8 {
    private long balance;

    public Account_8(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) throws InvalidAmountException_8 {
        if (amount <= 0) {
            throw new InvalidAmountException_8("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(long amount)
            throws InsufficientFundsException_8, InvalidAmountException_8 {
        if (amount <= 0) {
            throw new InvalidAmountException_8("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            long shortfall = amount - balance;
            throw new InsufficientFundsException_8(
                "Not enough balance. Shortfall: " + shortfall, shortfall
            );
        }
        balance -= amount;
    }

    public void transfer(Account_8 to, long amount) throws BankException_8 {
        try {
            if (to == null) {
                throw new AccountNotFoundException_8("Destination account was not found.");
            }
            withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer successful: " + amount);
        } catch (BankException_8 e) {
            throw e;
        } finally {
            System.out.println("Transfer operation finished.");
        }
    }
}
