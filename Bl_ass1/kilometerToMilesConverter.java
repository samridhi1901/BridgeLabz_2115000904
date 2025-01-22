import java.util.Scanner;

public class KilometerToMilesConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the distance in kilometers:");
        double kilometers = scanner.nextDouble();

        double miles = kilometers * 0.621371;
        System.out.println("The distance in miles is: " + miles);
    }
}
