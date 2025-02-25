import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "large_file.csv";  
        int chunkSize = 100;  

        processCSVInChunks(filePath, chunkSize);
    }

    public static void processCSVInChunks(String filePath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            int count = 0, batchCount = 0;

            while ((line = br.readLine()) != null) {
                if (isHeader) {  
                    isHeader = false;
                    continue;
                }

                count++;

                if (count % chunkSize == 0) {
                    batchCount++;
                    System.out.println("Processed " + count + " records...");
                }
            }

            System.out.println("Total Records Processed: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
