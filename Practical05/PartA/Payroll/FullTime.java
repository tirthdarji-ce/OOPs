public class FullTime extends Employee {
    private double salary;

    public FullTime(String name, String id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    public double monthlySalary() {
        return salary;
    }
}
