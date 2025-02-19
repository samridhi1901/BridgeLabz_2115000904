import java.util.*;

class RotateList {
    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        k = k % n; 
        if (k == 0) return;

        List<T> rotated = new ArrayList<>(list.subList(k, n));
        rotated.addAll(list.subList(0, k));

        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements (space-separated): ");
        String[] input = scanner.nextLine().split(" ");
        
        System.out.print("Enter rotation count: ");
        int k = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (String s : input) {
            list.add(Integer.parseInt(s));
        }

        rotateList(list, k);
        System.out.println("Rotated List: " + list);

        scanner.close();
    }
}
