import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("201,Sam,HR,50000\n");
            writer.append("202,Anu,IT,70000\n");
            writer.append("203,Tan,Finance,65000\n");
            writer.append("204,Div,Marketing,60000\n");
            writer.append("205,Ady,Sales,55000\n");
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
