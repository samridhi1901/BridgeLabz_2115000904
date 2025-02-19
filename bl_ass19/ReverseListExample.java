import java.util.*;

class ReverseListExample {
    public static <T> void reverseArrayList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> reversed = new LinkedList<>();
        for (T item : list) {
            reversed.addFirst(item);
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.print("Enter elements (space-separated): ");
        String[] input = scanner.nextLine().split(" ");

        for (String s : input) {
            int num = Integer.parseInt(s);
            arrayList.add(num);
            linkedList.add(num);
        }

        reverseArrayList(arrayList);
        linkedList = reverseLinkedList(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);

        scanner.close();
    }
}
