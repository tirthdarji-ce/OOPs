public class SMSSender implements Urgent {
    private String mobile;

    public SMSSender(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }
}
