public class Account_9 {


    private long balance = 0;

    public void deposit(long amount) {
        long temp = balance;
        Thread.yield();
        balance = temp + amount;
    }

    public long getBalance() {
        return balance;
    }
}
