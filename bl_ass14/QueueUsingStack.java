import java.util.*;

class QueueUsingStack {
    static class Queue {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        void enQueue(int x) {
            s1.push(x);
        }

        int deQueue() {
            if (s1.isEmpty() && s2.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        void displayQueue() {
            if (s1.isEmpty() && s2.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            
            System.out.print("Final Queue: ");
            for (int i = s2.size() - 1; i >= 0; i--) {
                System.out.print(s2.get(i) + " ");
            }
            for (int i = 0; i < s1.size(); i++) {
                System.out.print(s1.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        
        System.out.print("Enter the number of elements to enqueue initially: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            q.enQueue(sc.nextInt());
        }
        
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter a number to enqueue: ");
                    int num = sc.nextInt();
                    q.enQueue(num);
                    break;
                case 2:
                    int dequeued = q.deQueue();
                    if (dequeued != -1) {
                        System.out.println("Dequeued element: " + dequeued);
                    }
                    break;
                case 3:
                    q.displayQueue();
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
