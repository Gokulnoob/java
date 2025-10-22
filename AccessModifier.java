class Employee {
    // Access Specifiers
    public String name;       // Accessible everywhere
    protected int employeeId; // Accessible within the package and by subclasses
    private double salary;    // Accessible only within the Employee class

    // Corrected constructor: placed outside of the variable declarations block
    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name:" + name);
        System.out.println("Employee ID:" + employeeId);
        System.out.println("Salary:$" + salary);
    }

    // Protected method, accessible by subclasses
    protected void calculateBonus() {
        double bonus = salary * 0.1; // Accessing private 'salary' within the class
        System.out.println("Bonus:$" + bonus);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int employeeId, double salary, String department) {
        super(name, employeeId, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department:" + department);
    }
}

class Staff extends Employee {
    private int workingHours;

    public Staff(String name, int employeeId, double salary, int workingHours) {
        super(name, employeeId, salary);
        this.workingHours = workingHours;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Working Hours:" + workingHours);
    }
}

public class AccessModifier {
    public static void main(String[] args) {
        Manager manager = new Manager("Mr.X", 101, 50000.0, "Sales");
        Staff staff = new Staff("Mr.Y", 202, 60000.0, 50);

        System.out.println("Manager Details:");
        manager.displayDetails();
        manager.calculateBonus(); // Protected method is accessible from subclass object

        System.out.println();

        System.out.println("Staff Details:");
        staff.displayDetails();
        staff.calculateBonus(); // Protected method is accessible from subclass object
    }
}