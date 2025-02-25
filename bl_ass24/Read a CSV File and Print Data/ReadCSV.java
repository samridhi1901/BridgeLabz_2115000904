import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    System.out.printf("%-10s %-20s %-5s %-6s%n", data[0], data[1], data[2], data[3]);
                    System.out.println("---------------------------------------------");
                    isHeader = false;
                } else {
                    System.out.printf("%-10s %-20s %-5s %-6s%n", data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
