public class CurrentAccount extends Account {
    private long overdraftLimit;
    public CurrentAccount(String owner,long opening,long limit){super(owner,opening);overdraftLimit=limit;}
    public double interestRate(){return 0.0;}
    public boolean canWithdraw(long amount){return balance-amount>=-overdraftLimit;}
}
