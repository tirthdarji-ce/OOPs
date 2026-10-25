public class ParkingLot {

    private int TwoWheelers;
    private int FourWheelers;

    private final int TwoCap;
    private final int FourCap;

    private static long revenue = 0;

    public ParkingLot(int TwoCap, int FourCap) {
        this.TwoCap = TwoCap;
        this.FourCap = FourCap;
    }

    public boolean park(String type) {

        if (type.equals("Two")) {

            if (TwoWheelers < TwoCap) {
                TwoWheelers++;
                revenue = revenue + 20;
                return true;
            }

        } else if (type.equals("Four")) {

            if (FourWheelers < FourCap) {
                FourWheelers++;
                revenue = revenue + 40;
                return true;
            }
        }

        System.out.println("Full");
        return false;
    }

    public void leave(String type) {

        if (type.equals("Two")) {

            if (TwoWheelers > 0) {
                TwoWheelers--;
            }

        } else if (type.equals("Four")) {


            if (FourWheelers > 0) {
                FourWheelers--;
            }
        }
    }

    public int getTwoWheelers() {
        return TwoWheelers;
    }

    public int getFourWheelers() {
        return FourWheelers;
    }

    public static long getRevenue() {
        return revenue;
    }
}