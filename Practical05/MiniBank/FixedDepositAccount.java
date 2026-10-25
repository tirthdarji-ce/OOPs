public class FixedDepositAccount extends Account {
    public FixedDepositAccount(String owner,long opening){super(owner,opening);}
    public double interestRate(){return 7.0;}
    public boolean canWithdraw(long amount){return false;}
}
