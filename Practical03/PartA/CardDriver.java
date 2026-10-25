import java.util.Scanner;

public class CardDriver {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Card[] cards = new Card[10];
        int count = 0;

        System.out.print("Enter number of cards: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter rank: ");
            String rank = sc.nextLine();

            System.out.print("Enter suit: ");
            String suit = sc.nextLine();

            Card newCard = new Card(rank, suit);

            // Check with earlier cards
            boolean duplicate = false;

            for (int j = 0; j < count; j++) {
                if (newCard.equals(cards[j])) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("Duplicate found: " + newCard);
                break;
            }

            cards[count] = newCard;
            count++;
        }

        sc.close();
    }
}

