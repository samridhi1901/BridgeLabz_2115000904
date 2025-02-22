import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected());
    }

    @Test
    void testConnectionClosed() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected());
    }
}
