import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    void userAuthentication() {
        System.out.println("User authentication in progress...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    void optimizeDatabase() {
        System.out.println("Database optimization in progress...");
    }

    @Todo(task = "Enhance UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    void enhanceUI() {
        System.out.println("UI enhancements in progress...");
    }
}

public class TodoScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to retrieve pending tasks...");
        scanner.nextLine();

        Project project = new Project();
        Method[] methods = project.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("---------------------------");
            }
        }

        scanner.close();
    }
}
