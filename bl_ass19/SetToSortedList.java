import java.util.*;

class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // Sort in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements for the Set (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        Set<Integer> set = new HashSet<>();
        for (String s : input) {
            set.add(Integer.parseInt(s));
        }

        List<Integer> sortedList = convertToSortedList(set);
        System.out.println("Sorted List: " + sortedList);

        scanner.close();
    }
}
