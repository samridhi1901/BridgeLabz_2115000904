import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "Null pointer exception on edge cases")
    @BugReport(description = "Performance issue with large input")
    void fixBugs() {
        System.out.println("Fixing reported bugs...");
    }
}

public class RepeatableAnnotationTest {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter to retrieve bug reports...");
        scanner.nextLine();

        BugTracker tracker = new BugTracker();
        Method method = tracker.getClass().getMethod("fixBugs");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Description: " + bug.description());
            }
        }

        tracker.fixBugs();
        scanner.close();
    }
}
