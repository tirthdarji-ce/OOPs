import java.util.Scanner;

public class NotificationMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter mobile number: ");
        String mobile = sc.nextLine();

        System.out.print("Enter message: ");
        String message = sc.nextLine();

        EmailSender emailObject = new EmailSender(email);
        SMSSender smsObject = new SMSSender(mobile);

        Notifier emailSender =
                msg -> System.out.println("Email to "
                        + emailObject.getEmail() + ": " + msg);

        Notifier smsSender =
                msg -> System.out.println("SMS to "
                        + smsObject.getMobile() + ": " + msg);

        Notifier[] senders = {emailSender, smsSender};

        System.out.println("\nBroadcast:");
        for (Notifier sender : senders) {
            sender.send(message);
        }

        System.out.println("\nUrgent send:");
        for (Notifier sender : senders) {
            sender.send(message);
            sender.send(message);
        }

        sc.close();
    }
}
