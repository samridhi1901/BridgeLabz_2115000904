import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class ProgrammingLanguageExtractor {
    public static ArrayList<String> extractLanguages(String text) {
        ArrayList<String> languages = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(JavaScript|Java|Python|C\\+\\+|C#|Go|Ruby|Swift|Kotlin|PHP|TypeScript|Rust)\\b").matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        ArrayList<String> languages = extractLanguages(text);
        if (languages.isEmpty()) {
            System.out.println("No programming languages found");
        } else {
            System.out.println(String.join(", ", languages));
        }
        scanner.close();
    }
}
