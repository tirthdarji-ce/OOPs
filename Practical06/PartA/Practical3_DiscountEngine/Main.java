import java.util.Scanner;
import discount.DiscountEngine;
import discount.DiscountRule;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of prices: ");
        int n = sc.nextInt();

        double[] prices = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price " + (i + 1) + ": ");
            prices[i] = sc.nextDouble();
        }

        System.out.println("\nChoose discount:");
        System.out.println("1. 10% discount");
        System.out.println("2. 20% discount");
        System.out.println("3. No discount");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        if (choice == 1) {
            rule = price -> price * 0.90;
        } else if (choice == 2) {
            rule = price -> price * 0.80;
        } else {
            rule = price -> price;
        }

        System.out.println("\nResults:");
        DiscountEngine.apply(rule, prices);

        sc.close();
    }
}
