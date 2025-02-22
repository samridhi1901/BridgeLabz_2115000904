import java.util.Scanner;

public class BadWordCensor {
    public static String censorBadWords(String text, String[] badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] badWords = {"damn", "stupid"};
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        System.out.println(censorBadWords(text, badWords));
        scanner.close();
    }
}
