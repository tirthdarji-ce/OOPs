
import java.util.ArrayList;
import java.util.Scanner;

class MyStack<T> {
    private ArrayList<T> list = new ArrayList<>();

    // Add an element
    void push(T value) {
        list.add(value);
    }

    // Remove and return the top element
    T pop() {
        if (list.isEmpty()) {
            return null;
        }

        return list.remove(list.size() - 1);
    }

    // Display the top element
    T peek() {
        if (list.isEmpty()) {
            return null;
        }

        return list.get(list.size() - 1);
    }

    boolean isEmpty() {
        return list.isEmpty();
    }
}

public class GenericStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Stack of integers
        MyStack<Integer> numbers = new MyStack<>();

        System.out.print("How many integers? ");
        int n = sc.nextInt();

        System.out.println("Enter integers:");
        for (int i = 0; i < n; i++) {
            numbers.push(sc.nextInt());
        }

        System.out.println("Popped integer: " + numbers.pop());

        // Stack of strings
        MyStack<String> names = new MyStack<>();

        sc.nextLine();
        System.out.print("Enter a name: ");
        names.push(sc.nextLine());

        System.out.println("Popped name: " + names.pop());

        // Handle empty stack
        System.out.println("Empty stack pop: " + numbers.pop());

        sc.close();
    }
}
