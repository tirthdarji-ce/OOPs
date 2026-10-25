
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "NAME")
    String name;

    @Column(name = "MARKS")
    int marks;

    @Column(name = "GRADE")
    String grade;

    public String toString() {
        return "Name: " + name
                + "\nMarks: " + marks
                + "\nGrade: " + grade;
    }
}

public class ColumnMapper {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.print("Enter number of columns: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] header = new String[n];
        String[] row = new String[n];

        System.out.println("Enter column names:");
        for (int i = 0; i < n; i++) {
            header[i] = sc.nextLine().trim();
        }

        System.out.println("Enter student data in the same order:");
        for (int i = 0; i < n; i++) {
            row[i] = sc.nextLine();
        }

        for (Field f : Student.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(Column.class)) {
                String target = f.getAnnotation(Column.class).name();
                boolean found = false;

                for (int i = 0; i < n; i++) {
                    if (header[i].equalsIgnoreCase(target)) {
                        f.setAccessible(true);

                        if (f.getType() == int.class) {
                            f.setInt(s, Integer.parseInt(row[i].trim()));
                        } else {
                            f.set(s, row[i].trim());
                        }

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Missing column: " + target);
                }
            }
        }

        System.out.println("\n===== Student Details =====");
        System.out.println(s);

        sc.close();
    }
}
