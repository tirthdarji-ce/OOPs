
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of visitors: ");
        int n = sc.nextInt();

        HashSet<String> set = new HashSet<>();
        LinkedHashSet<String> order = new LinkedHashSet<>();

   
        for (int i = 0; i < n; i++) {
            String name = sc.next();

            set.add(name);
            order.add(name);
        }

       
        System.out.println("Unique count: " + set.size());

      
        System.out.println("First three unique visitors:");

        int count = 0;

        for (String name : order) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }

        sc.close();
    }
}
