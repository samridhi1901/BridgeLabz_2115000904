class Student {

    private static String universityName = "GLA";
    private static int totalStudents = 0;

    private final int rollNumber; 
    private String name;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    public static void displayTotalStudents() {
        System.out.println("Total students enrolled: " + totalStudents);
    }
    public void displayDetails() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    public void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            ((Student) obj).grade = newGrade;
            System.out.println("Grade updated for student: " + ((Student) obj).name);
        } else {
            System.out.println("Invalid operation! Object is not a Student.");
        }
    }

    public static void main(String[] args) {
       
        Student s1 = new Student("Anu", 101, "A");
        Student s2 = new Student("Sam", 102, "B");

        s1.displayDetails();
        s2.displayDetails();

        s1.updateGrade(s2, "A+");

        s2.displayDetails();
        Student.displayTotalStudents();
    }
}