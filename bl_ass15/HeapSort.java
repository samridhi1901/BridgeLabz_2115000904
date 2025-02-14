import java.util.Scanner;
import java.util.Arrays;

public class HeapSort {
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            heapify(salaries, i, 0);
        }
    }

    public static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != i) {
            double temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of job applications: ");
        int n = scanner.nextInt();
        double[] salaryDemands = new double[n];

        System.out.println("Enter the salary demands:");
        for (int i = 0; i < n; i++) {
            salaryDemands[i] = scanner.nextDouble();
        }

        heapSort(salaryDemands);

        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));

        scanner.close();
    }
}
