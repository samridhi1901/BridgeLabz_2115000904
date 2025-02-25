import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "contacts.csv";  
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String email = data[2].trim();  
                String phone = data[3].trim();  

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    System.out.println("Invalid Record: " + line);
                    if (!emailMatcher.matches()) {
                        System.out.println("  -> Invalid Email: " + email);
                    }
                    if (!phoneMatcher.matches()) {
                        System.out.println("  -> Invalid Phone Number: " + phone);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
