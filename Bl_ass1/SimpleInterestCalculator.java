import java.util.Scanner;

class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the principal amount: ");
        double principalAmount = scanner.nextDouble();
        
        System.out.print("Enter the rate of interest: ");
        double interestRate = scanner.nextDouble();
        
        System.out.print("Enter the time period: ");
        double timePeriod = scanner.nextDouble();
        
        double simpleInterest = (principalAmount * interestRate * timePeriod) / 100;
        System.out.println("The Simple Interest is: " + simpleInterest);
    }
}

