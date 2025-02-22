import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calculator.add(6, 4));
    }

    @Test
    void testSubtraction() {
        assertEquals(2, calculator.subtract(6, 4));
    }

    @Test
    void testMultiplication() {
        assertEquals(24, calculator.multiply(6, 4));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(8, 4));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(8, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
