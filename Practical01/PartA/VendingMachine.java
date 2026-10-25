import java.util.Scanner;

public class VendingMachine {
    enum Coin { ONE, TWO, FIVE, TEN }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = 15;
        int total = 0;

        System.out.println("Snack price = 15");
        while (total < price) {
            System.out.print("Enter coin (ONE/TWO/FIVE/TEN): ");
            String input = sc.next().toUpperCase();
            try {
                Coin coin = Coin.valueOf(input);
                int value = switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };
                total += value;
                System.out.println("Total paid = " + total);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid coin. Try again.");
            }
        }
        System.out.println("Paid. Change: " + (total - price));
    }
}
