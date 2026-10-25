
public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;


    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Account Number: " + accountNumber
                + ", Owner: " + ownerName
                + ", Balance: " + balance;
    }

   
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Account))
            return false;

        Account other = (Account) o;

        return accountNumber.equals(other.accountNumber);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}

