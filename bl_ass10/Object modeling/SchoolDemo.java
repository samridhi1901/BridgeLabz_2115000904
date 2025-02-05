import java.util.ArrayList;
import java.util.List;

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void showEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " has the following students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Sam");
        Student student2 = new Student("Anu");

        school.addStudent(student1);
        school.addStudent(student2);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);

        school.showStudents();
        student1.showEnrolledCourses();
        student2.showEnrolledCourses();
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}
