import java.util.Scanner;
import java.util.regex.*;
import java.util.HashSet;

public class RepeatingWordsFinder {
    public static HashSet<String> findRepeatingWords(String text) {
        HashSet<String> words = new HashSet<>();
        HashSet<String> repeatedWords = new HashSet<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b").matcher(text);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (!words.add(word)) {
                repeatedWords.add(word);
            }
        }
        return repeatedWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        HashSet<String> repeatedWords = findRepeatingWords(text);
        if (repeatedWords.isEmpty()) {
            System.out.println("No repeating words found");
        } else {
            System.out.println(String.join(", ", repeatedWords));
        }
        scanner.close();
    }
}
