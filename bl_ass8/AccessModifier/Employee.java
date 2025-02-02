class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount. Salary must be positive.");
        }
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    private String team;

    public Manager(int employeeID, String department, double salary, String team) {
        super(employeeID, department, salary);
        this.team = team;
    }

    public void displayManagerInfo() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID);  // Public - Accessible
        System.out.println("Department: " + department);  // Protected - Accessible in subclass
        System.out.println("Managing Team: " + team);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "HR", 50000);
        emp1.displayEmployeeInfo();
        System.out.println();

        emp1.setSalary(55000);
        System.out.println("Updated Salary: $" + emp1.getSalary());
        System.out.println();

        Manager manager1 = new Manager(201, "IT", 80000, "Software Development");
        manager1.displayManagerInfo();
    }
}