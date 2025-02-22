import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class LinkExtractor {
    public static ArrayList<String> extractLinks(String text) {
        ArrayList<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\bhttps?://[a-zA-Z0-9._%+-]+\\.[a-zA-Z]{2,6}(/[a-zA-Z0-9._%+-]*)*\\b").matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        ArrayList<String> links = extractLinks(text);
        if (links.isEmpty()) {
            System.out.println("No links found");
        } else {
            System.out.println(String.join(", ", links));
        }
        scanner.close();
    }
}
