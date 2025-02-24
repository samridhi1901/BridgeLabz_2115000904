import java.lang.reflect.Constructor;
import java.util.Scanner;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        try {
            Constructor<Student> constructor = Student.class.getDeclaredConstructor(String.class, int.class);
            Student student = constructor.newInstance(name, age);
            student.display();
        } catch (Exception e) {
            System.out.println("Error creating object: " + e.getMessage());
        }

        scanner.close();
    }
}
