package modell;
public interface InterestBearingg {
    double interestRate();
    long getBalance();
    default double yearlyInterest() {
        return getBalance() * interestRate() / 100.0;
    }
}
