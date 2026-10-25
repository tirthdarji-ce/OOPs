
import java.util.Scanner;

class Box<T> {
    private T value;

    public void set(T v) {
        value = v;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    A first;
    B second;

    Pair(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return first + " | " + second;
    }
}

public class GenericDemo {

    static <T> T first(T[] a) {
        return a[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        Box<String> b = new Box<>();
        b.set(name);

        System.out.println("Box: " + b.get());

        Pair<String, Integer> p = new Pair<>(name, age);
        System.out.println("Pair: " + p);

        String[] a = {name, "Second"};

        System.out.println("First: " + first(a));

        sc.close();
    }
}
