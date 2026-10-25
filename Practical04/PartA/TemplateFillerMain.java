import java.util.Scanner;

public class TemplateFillerMain {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Template: ");
        String template = sc.nextLine();

        System.out.print("Enter number of supplied values: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        String[] values = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter placeholder name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter value: ");
            values[i] = sc.nextLine();
        }

        String result = TemplateFiller.fillTemplate(template, names, values);

        System.out.println("\nFilled Template:");
        System.out.println(result);

        sc.close();
    }
}