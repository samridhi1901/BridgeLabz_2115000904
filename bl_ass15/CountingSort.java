import java.util.Scanner;
import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages) {
        int minAge = 10, maxAge = 18;
        int range = maxAge - minAge + 1;
        int n = ages.length;

        int[] count = new int[range];
        int[] output = new int[n];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        System.arraycopy(output, 0, ages, 0, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] studentAges = new int[n];

        System.out.println("Enter the ages of students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            studentAges[i] = scanner.nextInt();
        }

        countingSort(studentAges);

        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));

        scanner.close();
    }
}
