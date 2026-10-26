public class AccountWorker_9 implements Runnable {

    private Account_9 account;
    private int times;
    private long amount;

    public AccountWorker_9(Account_9 account, int times, long amount) {
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
