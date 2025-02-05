import java.util.ArrayList;
import java.util.List;

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (dept.getName().equals(deptName)) {
                dept.addEmployee(new Employee(empName));
                return;
            }
        }
        System.out.println("Department not found: " + deptName);
    }

    public void showCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showEmployees();
        }
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            System.out.println("- " + emp.getName());
        }
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class CompanyDemo {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        
        company.addDepartment("Engineering");
        company.addDepartment("Marketing");
        
        company.addEmployeeToDepartment("Engineering", "Sam");
        company.addEmployeeToDepartment("Engineering", "Anu");
        company.addEmployeeToDepartment("Marketing", "alice");

        company.showCompanyStructure();
    }
}
