import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Application {
    @ImportantMethod
    void criticalProcess() {
        System.out.println("Executing critical process...");
    }

    @ImportantMethod(level = "MEDIUM")
    void backupProcess() {
        System.out.println("Executing backup process...");
    }

    void normalProcess() {
        System.out.println("Executing normal process...");
    }
}

public class AnnotationScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to retrieve important methods...");
        scanner.nextLine();

        Application app = new Application();
        Method[] methods = app.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }

        scanner.close();
    }
}
