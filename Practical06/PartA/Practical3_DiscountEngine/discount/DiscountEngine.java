package discount;

public class DiscountEngine {
    public static void apply(DiscountRule rule, double[] prices) {
        for (double price : prices) {
            double finalPrice = rule.apply(price);
            System.out.println("Original: " + price
                    + "  Final: " + finalPrice);
        }
    }
}
