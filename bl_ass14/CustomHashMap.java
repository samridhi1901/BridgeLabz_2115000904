import java.util.LinkedList;
import java.util.Scanner;

class CustomHashMap<K, V> {
    private static final int SIZE = 16; 
    private LinkedList<Entry<K, V>>[] buckets;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        if (buckets[index] == null) return null;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (buckets[index] == null) return;
        buckets[index].removeIf(entry -> entry.key.equals(key));
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            if (buckets[i] != null) {
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.println("Key: " + entry.key + ", Value: " + entry.value);
                }
            }
        }
    }
}

public class CustomHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Key-Value");
            System.out.println("2. Get Value by Key");
            System.out.println("3. Remove Key");
            System.out.println("4. Display HashMap");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    map.put(key, value);
                    System.out.println("Key-Value inserted!");
                    break;

                case 2:
                    System.out.print("Enter key to get value: ");
                    key = scanner.nextLine();
                    Integer result = map.get(key);
                    System.out.println(result != null ? "Value: " + result : "Key not found!");
                    break;

                case 3:
                    System.out.print("Enter key to remove: ");
                    key = scanner.nextLine();
                    map.remove(key);
                    System.out.println("Key removed if it existed.");
                    break;

                case 4:
                    System.out.println("Current HashMap contents:");
                    map.display();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
