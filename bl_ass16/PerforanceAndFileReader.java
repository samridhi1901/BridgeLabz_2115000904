import java.io.*;
import java.util.StringTokenizer;

public class PerformanceAndFileReader {
    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();
        countWordsInFile("largefile.txt"); // Change to your file path
    }

    public static void compareStringBuilderAndStringBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long timeBuffer = endTimeBuffer - startTimeBuffer;

        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long timeBuilder = endTimeBuilder - startTimeBuilder;

        System.out.println("StringBuffer time: " + timeBuffer / 1_000_000.0 + " ms");
        System.out.println("StringBuilder time: " + timeBuilder / 1_000_000.0 + " ms");
    }

    public static void countWordsInFile(String filePath) {
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
            System.out.println("Total words in file: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
