import java.io.*;
import java.util.*;

class Student {  // Defined in the same file
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}

public class CSVToStudentList {
    public static void main(String[] args) {
        String filePath = "students.csv";  
        List<Student> students = readCSV(filePath);

        System.out.println("Student Records:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());

                studentList.add(new Student(id, name, age, marks));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return studentList;
    }
}
