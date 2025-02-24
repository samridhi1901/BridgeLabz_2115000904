import java.lang.reflect.Method;
import java.util.Scanner;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodInvoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        Calculator calculator = new Calculator();

        try {
            Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);

            int result = (int) method.invoke(calculator, num1, num2);
            System.out.println("Multiplication Result: " + result);
        } catch (Exception e) {
            System.out.println("Error accessing private method: " + e.getMessage());
        }

        scanner.close();
    }
}
