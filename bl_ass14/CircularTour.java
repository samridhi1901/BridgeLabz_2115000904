import java.util.*;

class CircularTour {
    static int findStartingPump(int[] petrol, int[] distance) {
        int start = 0, surplus = 0, deficit = 0;

        for (int i = 0; i < petrol.length; i++) {
            surplus += petrol[i] - distance[i];
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol values:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.println("Enter distance values:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        int startPump = findStartingPump(petrol, distance);

        if (startPump == -1) {
            System.out.println("No possible circular tour.");
        } else {
            System.out.println("Start at petrol pump index: " + startPump);
        }

        sc.close();
    }
}
