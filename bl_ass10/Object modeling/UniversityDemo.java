import java.util.ArrayList;
import java.util.List;

class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> facultyMembers;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void showUniversityStructure() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.showDepartmentInfo();
        }
        System.out.println("Faculty Members:");
        for (Faculty faculty : facultyMembers) {
            System.out.println("- " + faculty.getName());
        }
    }
}

class Department {
    private String name;
    private List<Faculty> faculty;

    public Department(String name) {
        this.name = name;
        this.faculty = new ArrayList<>();
    }

    public void addFaculty(Faculty facultyMember) {
        faculty.add(facultyMember);
    }

    public void showDepartmentInfo() {
        System.out.println("Department: " + name);
        for (Faculty facultyMember : faculty) {
            System.out.println("  - Faculty: " + facultyMember.getName());
        }
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        University university = new University("Tech University");
        
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");
        
        Faculty profAlice = new Faculty("Professor Sam");
        Faculty profBob = new Faculty("Professor Anu");
        
        university.addFaculty(profAlice);
        university.addFaculty(profBob);
        
        university.showUniversityStructure();
    }
}
