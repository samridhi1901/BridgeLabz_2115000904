public class StudentLinkedList {
    Student head;

    void addAtBeginning(int rollNumber, String name, int age, String grade) {
        name = "Sam";
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    void addAtEnd(int rollNumber, String name, int age, String grade) {
        name = "Anu";
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newStudent;
    }

    void displayStudents() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No students found.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(1, "Alice", 20, "A");
        list.addAtEnd(2, "Bob", 21, "B");
        
        System.out.println("Student Records:");
        list.displayStudents();
    }
}

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
