
import java.io.*;

public class FileReaderWithResources {
    public static void main(String[] args) {
        String fileName = "info.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            System.out.println(firstLine != null ? firstLine : "File is empty");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
