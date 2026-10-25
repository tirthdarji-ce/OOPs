public abstract class Media {
    protected String title;
    protected int lateDays;

    public Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    public abstract double lateFee();
}
