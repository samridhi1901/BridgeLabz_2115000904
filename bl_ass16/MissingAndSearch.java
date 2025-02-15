import java.util.Arrays;

public class MissingAndSearch {
    
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1}; 
        int target = 3;

        int missing = findFirstMissingPositive(Arrays.copyOf(nums, nums.length));
        System.out.println("First missing positive integer: " + missing);

        Arrays.sort(nums);

        int index = binarySearch(nums, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}
