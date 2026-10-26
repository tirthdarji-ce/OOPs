public class AccountWorker__9 implements Runnable {

    private Account__9 account;
    private int times;
    private long amount;

    public AccountWorker__9(Account__9 account, int times, long amount) {
        this.account = account;
        this.times = times;
        this.amount = amount;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");

        for (int i = 0; i < times; i++) {
            account.deposit(amount);
        }

        System.out.println(name + " finished");
    }
}
