public class ChatFilter {

    public static void filter(String[] logs, String key) {

        int count = 0;

        System.out.println("\nMatching messages:");

        for (String line : logs) {

            if (line.toLowerCase().contains(key.toLowerCase())) {

                System.out.println(line);

                count++;
            }
        }

        System.out.println("Matches: " + count);
    }
}