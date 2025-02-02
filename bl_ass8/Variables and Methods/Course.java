public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Global Learning Academy";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public static String getInstituteName() {
        return instituteName;
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 8, 500.0);
        Course course2 = new Course("Data Science", 12, 900.0);

        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();

        Course.updateInstituteName("Tech University");

        System.out.println("After updating institute name:\n");
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
    }
}