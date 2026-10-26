import java.io.Serializable;
public class Account_11 implements Serializable {
    private static final long serialVersionUID=1L;
    private final String accountNumber; private String ownerName; private long balance; private static int counter=0;
    public Account_11(String owner,long opening){accountNumber=String.format("AC%04d",++counter);ownerName=owner;balance=opening;}
    public String getAccountNumber(){return accountNumber;} public long getBalance(){return balance;} public String getOwnerName(){return ownerName;}
    public void deposit(long a){balance+=a;} public boolean withdraw(long a){if(a>balance)return false;balance-=a;return true;}
    public String toString(){return accountNumber+" | "+ownerName+" | "+balance;}
}
