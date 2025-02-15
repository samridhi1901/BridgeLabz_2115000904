public class SentenceSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue.",
            "I love programming in Java.",
            "This is a simple search problem.",
            "Data structures are important."
        };

        String word = "Java";
        String result = findSentenceWithWord(sentences, word);

        System.out.println("Result: " + result);
    }
}
