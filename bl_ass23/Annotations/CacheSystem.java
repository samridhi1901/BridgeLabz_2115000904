import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveService {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result...");
            return cache.get(number);
        }
        System.out.println("Computing square...");
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}

public class CacheSystem {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ExpensiveService service = new ExpensiveService();
        Method method = service.getClass().getMethod("computeSquare", int.class);

        while (true) {
            System.out.print("Enter a number (or -1 to exit): ");
            int num = scanner.nextInt();
            if (num == -1) break;

            if (method.isAnnotationPresent(CacheResult.class)) {
                System.out.println("Result: " + service.computeSquare(num));
            }
        }

        scanner.close();
    }
}
