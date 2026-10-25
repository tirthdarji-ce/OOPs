public class Magazine extends Media {
    public Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    public double lateFee() {
        return lateDays * 1;
    }
}
