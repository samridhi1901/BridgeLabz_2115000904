import java.util.*;

class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter elements (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        
        List<String> itemList = Arrays.asList(input);
        Map<String, Integer> frequency = countFrequency(itemList);

        System.out.println("Frequency Map: " + frequency);
        
        scanner.close();
    }
}
