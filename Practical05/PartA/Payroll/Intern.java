public class Intern extends Employee {
    private double stipend;

    public Intern(String name, String id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    public double monthlySalary() {
        return stipend;
    }
}
