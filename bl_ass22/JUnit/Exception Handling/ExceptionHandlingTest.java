import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExceptionHandlingTest {
    private final ExceptionHandling exceptionHandling = new ExceptionHandling();

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> exceptionHandling.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
