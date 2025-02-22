import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class DateExtractor {
    public static ArrayList<String> extractDates(String text) {
        ArrayList<String> dates = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b").matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        ArrayList<String> dates = extractDates(text);
        if (dates.isEmpty()) {
            System.out.println("No dates found");
        } else {
            System.out.println(String.join(", ", dates));
        }
        scanner.close();
    }
}
