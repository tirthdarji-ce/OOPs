public class Account_12 implements Comparable<Account_12> {
    private final String accountNumber; private String ownerName; private long balance; private static int counter=0;
    public Account_12(String owner,long balance){accountNumber=String.format("AC%04d",++counter);ownerName=owner;this.balance=balance;}
    public String getAccountNumber(){return accountNumber;}public long getBalance(){return balance;}public String getOwnerName(){return ownerName;}
    public void deposit(long a){balance+=a;} public int compareTo(Account_12 a){return accountNumber.compareTo(a.accountNumber);}
    public String toString(){return accountNumber+" | "+ownerName+" | "+balance;}
}
