import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "data.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Map<String, List<String>> recordMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String id = parts[0].trim();
                    recordMap.putIfAbsent(id, new ArrayList<>());
                    recordMap.get(id).add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        boolean foundDuplicate = false;
        for (Map.Entry<String, List<String>> entry : recordMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                foundDuplicate = true;
                System.out.println("Duplicate records for ID " + entry.getKey() + ":");
                for (String record : entry.getValue()) {
                    System.out.println(record);
                }
                System.out.println();
            }
        }
        if (!foundDuplicate) {
            System.out.println("No duplicate records found.");
        }
    }
}
