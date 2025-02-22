import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class EmailExtractor {
    public static ArrayList<String> extractEmails(String text) {
        ArrayList<String> emails = new ArrayList<>();
        Matcher matcher = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        ArrayList<String> emails = extractEmails(text);
        if (emails.isEmpty()) {
            System.out.println("No emails found");
        } else {
            for (String email : emails) {
                System.out.println(email);
            }
        }
        scanner.close();
    }
}
