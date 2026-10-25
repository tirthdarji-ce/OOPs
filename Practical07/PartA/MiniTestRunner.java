
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {

    @Run
    public void first() {
        System.out.println("First test passed");
    }

    @Run
    public void second() {
        System.out.println("Second test passed");
    }

    @Run
    public void third() {
        System.out.println("Third test passed");
    }

    public void skip() {
        System.out.println("This test should not run");
    }
}

public class MiniTestRunner {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        MyTests test = new MyTests();

        Method[] methods = MyTests.class.getDeclaredMethods();
        int count = 0;

        System.out.println("===== Mini Test Runner =====");
        System.out.println("1. First test");
        System.out.println("2. Second test");
        System.out.println("3. Third test");
        System.out.println("0. Run all tests");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Run.class)) {

                String name = method.getName();
                int number = 0;

                if (name.equals("first")) number = 1;
                else if (name.equals("second")) number = 2;
                else if (name.equals("third")) number = 3;

                if (choice == 0 || choice == number) {
                    method.invoke(test);
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println("Invalid choice!");
        }

        System.out.println("Tests ran: " + count);
        sc.close();
    }
}
