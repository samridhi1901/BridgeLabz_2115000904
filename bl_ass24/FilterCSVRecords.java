import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "students.csv";  
        filterHighScorers(filePath);
    }

    public static void filterHighScorers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    System.out.printf("%-5s %-15s %-5s %-6s%n", data[0], data[1], data[2], data[3]);
                    System.out.println("--------------------------------");
                    isHeader = false;
                    continue;
                }

                int marks = Integer.parseInt(data[3]); 

                if (marks > 80) {
                    System.out.printf("%-5s %-15s %-5s %-6s%n", data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
