import java.util.*;

class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2); // Union of both sets

        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2); // Intersection of both sets

        unionSet.removeAll(intersectionSet); // Remove common elements
        return unionSet;
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

        Set<Integer> symmetricDiff = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);

        scanner.close();
    }
}
