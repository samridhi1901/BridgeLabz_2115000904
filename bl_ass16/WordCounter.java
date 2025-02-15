import java.io.*;
import java.util.Scanner;

public class WordCounter {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the word to count: ");
        String targetWord = scanner.next();

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " times in the file.");

        scanner.close();
    }
}
