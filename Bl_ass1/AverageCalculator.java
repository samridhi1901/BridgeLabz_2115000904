import java.util.Scanner;

class AverageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int firstNumber = scanner.nextInt();

        System.out.println("Enter the second number:");
        int secondNumber = scanner.nextInt();

        System.out.println("Enter the third number:");
        int thirdNumber = scanner.nextInt();

        int averageValue = (firstNumber + secondNumber + thirdNumber) / 3;
        System.out.println("The average of the three numbers is: " + averageValue);
    }
}


