import java.util.*;

public class RPSLS {
    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }

    static int winner(Move a, Move b) {
        if (a == b) return 0;
        return switch (a) {
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;
            case ROCK -> (b == Move.LIZARD || b == Move.SCISSORS) ? 1 : -1;
            case LIZARD -> (b == Move.SPOCK || b == Move.PAPER) ? 1 : -1;
            case SPOCK -> (b == Move.SCISSORS || b == Move.ROCK) ? 1 : -1;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Move[] moves = Move.values();
        Random random = new Random();
        int you = 0, computer = 0;

        System.out.println("RPSLS - 5 rounds");
        for (int round = 1; round <= 5; round++) {
            System.out.print("Round " + round + " - enter ROCK/PAPER/SCISSORS/LIZARD/SPOCK: ");
            Move player;
            try {
                player = Move.valueOf(sc.next().toUpperCase());
            } catch (Exception e) {
                System.out.println("Invalid input. Round repeated.");
                round--;
                continue;
            }

            Move cpu = moves[random.nextInt(moves.length)];
            int result = winner(player, cpu);
            System.out.println("You: " + player + " | Computer: " + cpu);
            if (result > 0) { you++; System.out.println("You win this round."); }
            else if (result < 0) { computer++; System.out.println("Computer wins this round."); }
            else System.out.println("Tie.");
        }
        System.out.println("Score: You " + you + " - " + computer + " Computer");
        System.out.println(you > computer ? "You win!" : you < computer ? "Computer wins!" : "Overall tie!");
    }
}
