import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";  
        String outputFile = "updated_employees.csv"; 

        updateSalary(inputFile, outputFile);
    }

    public static void updateSalary(String inputFile, String outputFile) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    records.add(data);
                    isHeader = false;
                    continue;
                }

                if (data[2].equalsIgnoreCase("IT")) {  
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10;  
                    data[3] = String.format("%.2f", salary);
                }

                records.add(data);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String[] record : records) {
                writer.append(String.join(",", record)).append("\n");
            }
            System.out.println("Updated salaries saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
