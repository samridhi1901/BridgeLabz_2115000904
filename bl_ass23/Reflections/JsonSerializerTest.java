import java.lang.reflect.Field;

class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!first) {
                    json.append(", ");
                }
                json.append("\"").append(field.getName()).append("\": ");
                
                Object value = field.get(obj);
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                first = false;
            } catch (IllegalAccessException ignored) {
            }
        }

        json.append("}");
        return json.toString();
    }
}

// Example class to serialize
class User {
    private String name;
    private int age;
    private boolean active;

    public User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }
}

public class JsonSerializerTest {
    public static void main(String[] args) {
        User user = new User("Alice", 25, true);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
