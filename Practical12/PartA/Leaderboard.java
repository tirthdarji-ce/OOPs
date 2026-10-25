
import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of players: ");
        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        // Enter player names and scores
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name and score: ");
            String name = sc.next();
            int score = sc.nextInt();

            map.put(name, score);
        }

        // Sort players by score, highest first
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return Integer.compare(b.getValue(), a.getValue());
            }
            return a.getKey().compareTo(b.getKey());
        });

        System.out.print("Enter Top N: ");
        int top = sc.nextInt();

        // Display the top players
        System.out.println("Leaderboard:");

        for (int i = 0; i < Math.min(top, list.size()); i++) {
            System.out.println(
                    list.get(i).getKey() + " - "
                    + list.get(i).getValue()
            );
        }

        sc.close();
    }
}
