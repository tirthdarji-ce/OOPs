public class Account_13 {
    private static int count = 0;
    private String id;
    private String owner;
    private long balance;

    public Account_13(String owner, long balance) {
        this.id = String.format("AC%04d", ++count);
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id + " | " + owner + " | " + balance;
    }
}