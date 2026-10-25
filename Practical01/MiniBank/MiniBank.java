public class MiniBank {

    String name;
    int balance;

    MiniBank(String name) {
        this.name = name;
        balance = 0;
    }

    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void transfer(int amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Transferred: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void showBalance() {
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}