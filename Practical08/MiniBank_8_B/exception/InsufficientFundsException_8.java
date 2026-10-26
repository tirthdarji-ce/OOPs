package exception;

public class InsufficientFundsException_8 extends BankException_8 {
    private long shortfall;

    public InsufficientFundsException_8(String message, long shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public long getShortfall() {
        return shortfall;
    }
}
