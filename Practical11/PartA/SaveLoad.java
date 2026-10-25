
import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    transient String secret;

    Person(String name, String secret) {
        this.name = name;
        this.secret = secret;
    }

    public String toString() {
        return "Name: " + name + ", Secret: " + secret;
    }
}

public class SaveLoad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of persons: ");
            int n = Integer.parseInt(sc.nextLine());

            if (n <= 0) {
                System.out.println("Number must be positive.");
                return;
            }

            Person[] people = new Person[n];

            for (int i = 0; i < n; i++) {
                System.out.println("\nPerson " + (i + 1));

                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter secret: ");
                String secret = sc.nextLine();

                people[i] = new Person(name, secret);
            }

            // Save objects to a file
            try (ObjectOutputStream out =
                     new ObjectOutputStream(
                         new FileOutputStream("people.dat"))) {
                out.writeObject(people);
            }

            System.out.println("\nObjects saved successfully.");

            // Read objects back from the file
            try (ObjectInputStream in =
                     new ObjectInputStream(
                         new FileInputStream("people.dat"))) {

                Person[] loaded = (Person[]) in.readObject();

                System.out.println("\nLoaded objects:");

                for (Person p : loaded) {
                    System.out.println(p);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
