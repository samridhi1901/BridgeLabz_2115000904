import java.lang.reflect.Field;
import java.util.Scanner;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class PrivateFieldModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial age: ");
        int initialAge = scanner.nextInt();

        Person person = new Person(initialAge);
        person.displayAge();

        try {
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);

            System.out.print("Enter new age: ");
            int newAge = scanner.nextInt();

            ageField.set(person, newAge);
            person.displayAge();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error accessing private field: " + e.getMessage());
        }

        scanner.close();
    }
}
