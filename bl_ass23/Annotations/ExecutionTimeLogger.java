import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTester {
    @LogExecutionTime
    void fastMethod() {
        for (int i = 0; i < 1000; i++) {} // Simulated fast operation
        System.out.println("Fast method executed.");
    }

    @LogExecutionTime
    void slowMethod() {
        for (int i = 0; i < 1_000_000; i++) {} // Simulated slow operation
        System.out.println("Slow method executed.");
    }
}

public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to measure execution time...");
        scanner.nextLine();

        PerformanceTester tester = new PerformanceTester();
        Method[] methods = tester.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(tester);
                long endTime = System.nanoTime();
                System.out.println("Execution Time of " + method.getName() + ": " + (endTime - startTime) + " ns");
                System.out.println("---------------------------");
            }
        }

        scanner.close();
    }
}
