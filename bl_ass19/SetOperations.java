import java.util.*;

class SetOperations {
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements for Set1 (space-separated): ");
        String[] input1 = scanner.nextLine().split(" ");
        Set<Integer> set1 = new HashSet<>();
        for (String s : input1) {
            set1.add(Integer.parseInt(s));
        }

        System.out.print("Enter elements for Set2 (space-separated): ");
        String[] input2 = scanner.nextLine().split(" ");
        Set<Integer> set2 = new HashSet<>();
        for (String s : input2) {
            set2.add(Integer.parseInt(s));
        }

        Set<Integer> unionSet = union(set1, set2);
        Set<Integer> intersectionSet = intersection(set1, set2);

        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);

        scanner.close();
    }
}
