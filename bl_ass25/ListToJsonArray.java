import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Arrays;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = Arrays.asList(new Person("Alice", 25), new Person("Bob", 30));

        String jsonArray = objectMapper.writeValueAsString(people);
        System.out.println(jsonArray);
    }
}
