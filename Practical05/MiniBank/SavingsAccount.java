public class SavingsAccount extends Account {
    private long minBalance;
    public SavingsAccount(String owner,long opening,long min){super(owner,opening);minBalance=min;}
    public double interestRate(){return 4.0;}
    public boolean canWithdraw(long amount){return balance-amount>=minBalance;}
}
