
import java.util.Scanner;

public class BoundedStats {

    static <N extends Number> double average(N[] a) {
        double sum = 0;

        for (N n : a) {
            sum += n.doubleValue();
        }

        return sum / a.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers? ");
        int n = sc.nextInt();

        Double[] a = new Double[n];

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        System.out.println("Average: " + average(a));

        sc.close();
    }
}
