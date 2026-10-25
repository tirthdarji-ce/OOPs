package discount;

@FunctionalInterface
public interface DiscountRule {
    double apply(double price);
}
