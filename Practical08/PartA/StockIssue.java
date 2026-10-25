
import java.util.*;

class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        super("Out of stock. Short by " + shortfall);
        this.shortfall = shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    Map<String, Integer> stock = new HashMap<>();

    void add(String item, int qty) {
        stock.put(item, stock.getOrDefault(item, 0) + qty);
    }

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be positive."
            );
        }

        int available = stock.getOrDefault(item, 0);

        if (qty > available) {
            throw new OutOfStockException(qty - available);
        }

        stock.put(item, available - qty);
        System.out.println("Issue successful.");
    }
}

public class StockIssue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Warehouse w = new Warehouse();

        System.out.print("Enter number of stock requests: ");
        int n = sc.nextInt();

        System.out.print("Enter number of different stock items: ");
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            System.out.print("Enter item name and available quantity: ");
            String item = sc.next();
            int qty = sc.nextInt();
            w.add(item, qty);
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter requested item and quantity: ");
            String item = sc.next();
            int qty = sc.nextInt();

            try {
                w.issue(item, qty);
            } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
            } catch (InvalidQuantityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Remaining stock: " + w.stock);
        sc.close();
    }
}
