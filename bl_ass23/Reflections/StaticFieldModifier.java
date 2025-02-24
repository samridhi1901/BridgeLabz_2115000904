import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class StaticFieldModifier {
    public static void main(String[] args) {
        try {
            // Get the Configuration class and its private static field
            Class<Configuration> configClass = Configuration.class;
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible
            apiKeyField.setAccessible(true);

            // Modify the static field value
            apiKeyField.set(null, "NEW_SECRET_KEY");

            // Print the modified value
            System.out.println("Updated API Key: " + Configuration.getApiKey());
        } catch (Exception e) {
            System.out.println("Error modifying static field: " + e.getMessage());
        }
    }
}
