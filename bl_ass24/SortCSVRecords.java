import java.io.*;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "employees.csv";  
        sortBySalary(filePath);
    }

    public static void sortBySalary(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            String[] header = null;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    header = data;
                    isHeader = false;
                    continue;
                }
                records.add(data);
            }

            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

            System.out.printf("%-5s %-15s %-12s %-8s%n", header[0], header[1], header[2], header[3]);
            System.out.println("---------------------------------------");

            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] record = records.get(i);
                System.out.printf("%-5s %-15s %-12s %-8s%n", record[0], record[1], record[2], record[3]);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
