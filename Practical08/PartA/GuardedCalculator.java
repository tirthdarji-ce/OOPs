
import java.util.*;

class DivideByZeroException extends Exception {
    DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static double calculate(double a, double b, char op)
            throws DivideByZeroException {

        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new DivideByZeroException("Cannot divide by zero.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number: ");
                double a = sc.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                double result = calculate(a, b, op);

                System.out.println("Result: " + result);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please enter numeric values.");
                sc.nextLine();

            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Attempt finished.\n");
            }
        }

        sc.close();
    }
}
