import java.util.ArrayList;
import java.util.List;

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

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseName;
    private List<Student> students;
    private Professor professor;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " assigned to " + courseName);
    }
}

public class UniversityManagementDemo {
    public static void main(String[] args) {
        Student student1 = new Student("Sam");
        Student student2 = new Student("Anu");
        
        Professor professor = new Professor("Dr. Henry");
        
        Course course = new Course("Computer Science");
        course.assignProfessor(professor);
        
        student1.enrollCourse(course);
        student2.enrollCourse(course);
    }
}
