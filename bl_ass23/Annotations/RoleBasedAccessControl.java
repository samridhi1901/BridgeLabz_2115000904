import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    void performAdminTask() {
        System.out.println("Admin task executed successfully.");
    }

    void generalTask() {
        System.out.println("General task executed.");
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your role (USER/ADMIN): ");
        String userRole = scanner.nextLine().trim().toUpperCase();

        SecureService service = new SecureService();
        Method[] methods = service.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (!userRole.equals(requiredRole)) {
                    System.out.println("Access Denied! You need " + requiredRole + " role to execute " + method.getName());
                    continue;
                }
            }
            method.invoke(service);
        }

        scanner.close();
    }
}
