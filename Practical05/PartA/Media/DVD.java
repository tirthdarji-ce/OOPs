public class DVD extends Media {
    public DVD(String title, int lateDays) {
        super(title, lateDays);
    }

    public double lateFee() {
        return lateDays * 5;
    }
}
