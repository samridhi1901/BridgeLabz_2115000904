import java.util.*;

class StockSpan {

    static int[] calculateSpan(int prices[], int n) {
        int span[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        span[0] = 1;
        
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        
        return span;
    }

    static void printArray(int arr[]) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int prices[] = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int span[] = calculateSpan(prices, n);

        System.out.println("Stock span for each day:");
        printArray(span);

        sc.close();
    }
}
