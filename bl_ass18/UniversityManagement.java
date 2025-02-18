import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayEvaluationMethod();
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based Course");
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getName() + " - Evaluated through final exams.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based Course");
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getName() + " - Evaluated through assignments and projects.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based Course");
    }

    @Override
    public void displayEvaluationMethod() {
        System.out.println(getName() + " - Evaluated through research papers and thesis.");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        courseType.displayEvaluationMethod();
    }
}

class CourseManager {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayAllCourses() {
        for (Course<? extends CourseType> course : courses) {
            course.displayCourseInfo();
            System.out.println("--------------------");
        }
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Course<ExamCourse> mathCourse = new Course<>("Advanced Mathematics", new ExamCourse());
        Course<AssignmentCourse> csCourse = new Course<>("Software Engineering", new AssignmentCourse());
        Course<ResearchCourse> physicsCourse = new Course<>("Quantum Physics", new ResearchCourse());

        CourseManager manager = new CourseManager();
        manager.addCourse(mathCourse);
        manager.addCourse(csCourse);
        manager.addCourse(physicsCourse);

        System.out.println("University Courses:");
        manager.displayAllCourses();
    }
}
