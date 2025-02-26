import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarToJson {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2022);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
