import java.util.Scanner;

public class RemoteMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter fan name: ");

        String fanName = sc.nextLine();

        System.out.println("Enter light name: ");
        String lightName = sc.nextLine();

        System.out.println("Enter hour (0-23): ");
        int hour = sc.nextInt();

        Switchable[] devices = {
            new Fan(fanName),
            new Light(lightName)
        };

        System.out.println("\nToggling devices:");
        for (Switchable device : devices) {
            device.toggle();
        }

        SwitchRule anonymousRule = new SwitchRule() {
            public boolean maySwitchOn(Switchable device, int h) {
                return h >= 6 && h <= 22;
            }
        };

        SwitchRule lambdaRule =
                (device, h) -> h >= 8 && h <= 20;

        System.out.println("\nAnonymous class Rule: "

                + anonymousRule.maySwitchOn(devices[0], hour));

        System.out.println("Lambda Rule: "
                + lambdaRule.maySwitchOn(devices[1], hour));

        sc.close();
    }
}
