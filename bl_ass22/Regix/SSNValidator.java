import java.util.Scanner;
import java.util.regex.*;

public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        return ssn.matches("\\b\\d{3}-\\d{2}-\\d{4}\\b");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Social Security Number: ");
        String ssn = scanner.nextLine();
        if (isValidSSN(ssn)) {
            System.out.println(ssn + " is valid");
        } else {
            System.out.println(ssn + " is invalid");
        }
        scanner.close();
    }
}
