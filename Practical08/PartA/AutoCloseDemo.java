
import java.util.Scanner;

class MyResource implements AutoCloseable {

    public void use() {
        System.out.println("Resource used");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

public class AutoCloseDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = sc.nextLine();

        try (MyResource r = new MyResource()) {
            r.use();

            throw new RuntimeException(message);

        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
        }

        sc.close();
    }
}
