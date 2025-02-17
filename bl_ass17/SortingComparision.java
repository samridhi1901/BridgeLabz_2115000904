import java.util.Arrays;
public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = size - i;
            }
            int[] bubbleData = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            bubbleSort(bubbleData);
            long bubbleTime = System.nanoTime() - startTime;
            int[] mergeData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeTime = System.nanoTime() - startTime;
            int[] quickData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = System.nanoTime() - startTime;
            System.out.println("Bubble Sort Time: " + bubbleTime / 1_000_000.0 + " ms");
            System.out.println("Merge Sort Time: " + mergeTime / 1_000_000.0 + " ms");
            System.out.println("Quick Sort Time: " + quickTime / 1_000_000.0 + " ms");
            System.out.println("-----------------------------------");
        }
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
