import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) {
        String filePath = "output.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
