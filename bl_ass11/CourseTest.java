class Course {
    String courseName;
    int duration; // in weeks

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // in percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee + ", Discount: " + discount + "%, Final Fee: $" + calculateFinalFee());
    }
}

public class CourseTest {
    public static void main(String[] args) {
        Course basicCourse = new Course("Java Basics", 4);
        OnlineCourse onlineCourse = new OnlineCourse("Python for Data Science", 6, "Udemy", true);
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Full-Stack Web Development", 12, "Coursera", false, 500, 20);

        basicCourse.displayCourseInfo();
        System.out.println("----------------------");
        onlineCourse.displayCourseInfo();
        System.out.println("----------------------");
        paidCourse.displayCourseInfo();
    }
}
