import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Alice")
    void completeTask() {
        System.out.println("Task completed!");
    }
}

public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to retrieve task details...");
        scanner.nextLine();

        TaskManager taskManager = new TaskManager();
        Method method = taskManager.getClass().getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        taskManager.completeTask();
        scanner.close();
    }
}
