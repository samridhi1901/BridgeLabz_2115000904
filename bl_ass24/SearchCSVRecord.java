import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchCSVRecord {
    public static void main(String[] args) {
        String filePath = "employees.csv";  
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();

        searchEmployee(filePath, searchName);
        scanner.close();
    }

    public static void searchEmployee(String filePath, String searchName) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (data[1].equalsIgnoreCase(searchName)) { 
                    System.out.println("Employee Found:");
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
