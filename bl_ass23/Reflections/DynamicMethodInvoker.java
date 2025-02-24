import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOperations = new MathOperations();

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        try {
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
            int result = (int) method.invoke(mathOperations, num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid method name or error invoking method: " + e.getMessage());
        }

        scanner.close();
    }
}
