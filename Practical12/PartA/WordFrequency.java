
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter paragraph: ");
        String text = sc.nextLine().toLowerCase();

        text = text.replaceAll("[^a-z0-9 ]", " ");

        String[] words = text.split("\\s+");

        Map<String, Integer> map = new HashMap<>();

        // Count each word
        for (String word : words) {
            if (!word.isBlank()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Sort words by frequency
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        // Display the result
        System.out.println("Word frequencies:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                    entry.getKey() + " = " + entry.getValue()
            );
        }

        sc.close();
    }
}
