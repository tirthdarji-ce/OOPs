public class Light implements Switchable {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " is ON");
    }

    public void off() {
        System.out.println(name + " is OFF");
    }
}
