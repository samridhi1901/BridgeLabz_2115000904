import java.util.*;

class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();
        
        for (T item : list) {
            if (!seen.contains(item)) {
                seen.add(item);
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements (space-separated): ");
        String[] input = scanner.nextLine().split(" ");

        List<Integer> list = new ArrayList<>();
        for (String s : input) {
            list.add(Integer.parseInt(s));
        }

        List<Integer> uniqueList = removeDuplicates(list);
        System.out.println("List after removing duplicates: " + uniqueList);

        scanner.close();
    }
}
