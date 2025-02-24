import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

interface Service {
    void execute();
}

class EmailService implements Service {
    public void execute() {
        System.out.println("Sending an email...");
    }
}

class SMSService implements Service {
    public void execute() {
        System.out.println("Sending an SMS...");
    }
}

class NotificationManager {
    @Inject
    private Service service;

    public void notifyUser() {
        service.execute();
    }
}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public DIContainer() {
        instances.put(Service.class, new EmailService());
    }

    public void injectDependencies(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);

                if (dependency != null) {
                    field.setAccessible(true);
                    try {
                        field.set(object, dependency);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to inject dependency: " + fieldType, e);
                    }
                }
            }
        }
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        NotificationManager manager = new NotificationManager();

        container.injectDependencies(manager);
        manager.notifyUser();
    }
}
