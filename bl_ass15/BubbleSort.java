import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] studentMarks = new int[n];

        System.out.println("Enter the marks:");
        for (int i = 0; i < n; i++) {
            studentMarks[i] = scanner.nextInt();
        }

        bubbleSort(studentMarks);

        System.out.println("Sorted Marks: " + Arrays.toString(studentMarks));
        
        scanner.close();
    }
}
