import java.io.Serializable;
public abstract class Account implements Serializable {
    private static final long serialVersionUID=1L;
    protected final String accountNumber; protected String ownerName; protected long balance;
    private static int counter=0;
    public Account(String owner,long opening){accountNumber=String.format("AC%04d",++counter);ownerName=owner;balance=opening;}
    public abstract double interestRate();
    public abstract boolean canWithdraw(long amount);
    public long getBalance(){return balance;} public String getAccountNumber(){return accountNumber;} public String getOwnerName(){return ownerName;}
    public void deposit(long amount){if(amount>0)balance+=amount;}
    public boolean withdraw(long amount){if(amount<=0||!canWithdraw(amount))return false;balance-=amount;return true;}
    public String toString(){return accountNumber+" | "+ownerName+" | "+balance;}
}

