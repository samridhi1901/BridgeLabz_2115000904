
import java.util.Scanner;

class ComputeCircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        int circleRadius = scanner.nextInt();
        double piValue = 3.14;
        double circleArea = piValue * circleRadius * circleRadius;

        System.out.println("The area of the circle is: " + circleArea);
    }
}

