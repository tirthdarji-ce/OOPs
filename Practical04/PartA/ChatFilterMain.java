import java.util.Scanner;

public class ChatFilterMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of logs: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] logs = new String[n];

        System.out.println("Enter logs:");

        for (int i = 0; i < n; i++) {
            logs[i] = sc.nextLine();
        }

        System.out.print("Keyword: ");
        String key = sc.nextLine();

        ChatFilter.filter(logs, key);

        sc.close();
    }
}