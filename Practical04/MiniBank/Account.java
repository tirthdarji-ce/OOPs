public class Account {
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private static int counter=0;
    public Account(String ownerName,long balance){this.accountNumber=String.format("AC%04d",++counter);this.ownerName=ownerName;this.balance=balance;}
    public String getAccountNumber(){return accountNumber;} public String getOwnerName(){return ownerName;} public long getBalance(){return balance;}
    public void deposit(long a){balance+=a;} public boolean withdraw(long a){if(a>balance)return false;balance-=a;return true;}
}
