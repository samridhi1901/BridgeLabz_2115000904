import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class CurrencyExtractor {
    public static ArrayList<String> extractCurrencyValues(String text) {
        ArrayList<String> values = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\b\\d+\\.\\d{2}\\b").matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        ArrayList<String> values = extractCurrencyValues(text);
        if (values.isEmpty()) {
            System.out.println("No currency values found");
        } else {
            System.out.println(String.join(", ", values));
        }
        scanner.close();
    }
}
