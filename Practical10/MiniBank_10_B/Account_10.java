
public class Account_10 {
    private String name;
    private long balance;

    public Account_10(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public synchronized void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(name + " deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount: " + amount);
        }
    }

    public synchronized long getBalance() {
        return balance;
    }
}
