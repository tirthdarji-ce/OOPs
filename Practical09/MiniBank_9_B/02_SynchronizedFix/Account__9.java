public class Account__9 {

    private long balance = 0;

    public synchronized void deposit(long amount) {
        long temp = balance;
        Thread.yield();
        balance = temp + amount;
    }

    public long getBalance() {
        return balance;
    }
}
