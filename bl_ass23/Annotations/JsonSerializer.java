import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String toJson() {
        Map<String, String> jsonMap = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                try {
                    jsonMap.put(annotation.name(), field.get(this).toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Serialization error", e);
                }
            }
        }
        return jsonMap.toString().replace("=", ": ");
    }
}

public class JsonSerializer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        User user = new User(username, age);
        System.out.println("Serialized JSON: " + user.toJson());

        scanner.close();
    }
}
