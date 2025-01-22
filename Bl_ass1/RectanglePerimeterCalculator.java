import java.util.Scanner;
import java.util.*;
class RectanglePerimeterCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        int rectangleLength = scanner.nextInt();

        System.out.print("Enter the width of the rectangle: ");
        int rectangleWidth = scanner.nextInt();

        int rectanglePerimeter = 2 * (rectangleLength + rectangleWidth);
        System.out.println("The perimeter of the rectangle is: " + rectanglePerimeter);}}

