import java.util.Scanner;

class AddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the first value:");
        int value1 = scanner.nextInt();
        
        System.out.println("Enter the second value:");
        int value2 = scanner.nextInt();
        
        int result = value1 + value2;
        System.out.println("The sum of the two values is: " + result);
    }
}


