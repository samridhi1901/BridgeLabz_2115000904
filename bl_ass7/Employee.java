import java.util.Scanner;
class Employee{
	private String name;
	private int id;
	private double salary;
	public Employee(String name,int id,double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	public void displayDetails(){
		System.out.println("Employee Details");
		System.out.println("Name"+name);
		System.out.println("ID"+id);
		System.out.println("Salary :"+salary);
	}
	  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employee emp = new Employee(name, id, salary);
        emp.displayDetails();
        scanner.close();
    }
}