import java.util.*;

class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the list size");
            }
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements (space-separated): ");
        String[] input = scanner.nextLine().split(" ");

        LinkedList<String> list = new LinkedList<>(Arrays.asList(input));

        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        try {
            String nthElement = findNthFromEnd(list, n);
            System.out.println("Nth element from the end: " + nthElement);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
