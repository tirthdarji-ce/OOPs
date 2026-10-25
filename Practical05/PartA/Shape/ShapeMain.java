import java.util.Scanner;

public class ShapeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter circle radius: ");
        double r = sc.nextDouble();

        System.out.print("Enter rectangle length: ");
        double l = sc.nextDouble();

        System.out.print("Enter rectangle width: ");
        double w = sc.nextDouble();

        System.out.print("Enter triangle base: ");
        double b = sc.nextDouble();

        System.out.print("Enter triangle height: ");
        double h = sc.nextDouble();

        Shape[] shapes = {
            new Circle(r),
            new Rectangle(l, w),
            new Triangle(b, h)
        };

        double total = 0;
        double largest = 0;

        for (Shape s : shapes) {
            double a = s.area();
            System.out.println("Area = " + a);

            total += a;

            if (a > largest) {
                largest = a;
            }
        }

        System.out.println("Total area = " + total);
        System.out.println("Largest area = " + largest);

        sc.close();
    }
}
