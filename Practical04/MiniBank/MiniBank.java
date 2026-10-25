import java.util.Scanner;

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MiniBank Validation =====");

        System.out.print("Enter valid mobile: ");
        String mobile1 = sc.nextLine();

        System.out.print("Enter wrong mobile: ");
        String mobile2 = sc.nextLine();

        System.out.println("Mobile 1: " +
                Validator.isValidMobile(mobile1));

        System.out.println("Mobile 2: " +
                Validator.isValidMobile(mobile2));


        System.out.print("\nEnter valid email: ");
        String email1 = sc.nextLine();

        System.out.print("Enter wrong email: ");
        String email2 = sc.nextLine();

        System.out.println("Email 1: " +
                Validator.isValidEmail(email1));

        System.out.println("Email 2: " +
                Validator.isValidEmail(email2));


        System.out.print("\nEnter valid PAN: ");
        String pan1 = sc.nextLine();

        System.out.print("Enter wrong PAN: ");
        String pan2 = sc.nextLine();

        System.out.println("PAN 1: " +
                Validator.isValidPan(pan1));

        System.out.println("PAN 2: " +
                Validator.isValidPan(pan2));


        System.out.print("\nEnter valid IFSC: ");
        String ifsc1 = sc.nextLine();

        System.out.print("Enter wrong IFSC: ");
        String ifsc2 = sc.nextLine();

        System.out.println("IFSC 1: " +
                Validator.isValidIfsc(ifsc1));

        System.out.println("IFSC 2: " +
                Validator.isValidIfsc(ifsc2));


        System.out.println("\n===== Command Parser =====");

        System.out.print("Enter command: ");
        String line = sc.nextLine();

        Command command = CommandParser.parse(line);

        System.out.println("Transaction Type: " + command.type());
        System.out.println("Account Number: " + command.accountNumber());
        System.out.println("Amount: " + command.amount());

        sc.close();
    }
}