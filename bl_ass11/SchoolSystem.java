class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String position;

    public Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Position: " + position);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics");
        Student student = new Student("Bob Smith", 16, 10);
        Staff staff = new Staff("Charlie Brown", 40, "Administrator");

        teacher.displayDetails();
        teacher.displayRole();
        System.out.println("----------------------");

        student.displayDetails();
        student.displayRole();
        System.out.println("----------------------");

        staff.displayDetails();
        staff.displayRole();
    }
}
