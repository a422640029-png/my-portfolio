package airport;

public class employy extends person {
    private double salary;
    private double rewards;
    private static int coount = 1;
    private final int id;

    public employy(String name, String nathonalityId, String nathonality, double salary, double rewards) {
        super(name, nathonalityId, nathonality);
        this.salary = salary;
        this.id = coount++;
        this.rewards = rewards;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public double getRewards() { return rewards; }
    public void setRewards(double rewards) { this.rewards = rewards; }
    public int getId() { return id; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print(" | الراتب: " + getSalary() + " | المكافآت: " + getRewards() + " | ID الموظف: " + getId());
    }
}