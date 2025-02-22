import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class CapitalizedWordExtractor {
    public static ArrayList<String> extractCapitalizedWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        ArrayList<String> words = extractCapitalizedWords(text);
        if (words.isEmpty()) {
            System.out.println("No capitalized words found");
        } else {
            System.out.println(String.join(", ", words));
        }
        scanner.close();
    }
}
