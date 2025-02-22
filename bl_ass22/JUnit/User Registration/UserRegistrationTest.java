class UserRegistrationTest {

    @Test
    void testValidRegistration() {
        UserRegistration registration = new UserRegistration();
        assertDoesNotThrow(() -> registration.registerUser("JohnDoe", "john@example.com", "SecurePass1"));
    }

    @Test
    void testEmptyUsername() {
        UserRegistration registration = new UserRegistration();
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("", "john@example.com", "SecurePass1"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        UserRegistration registration = new UserRegistration();
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("JohnDoe", "invalid-email", "SecurePass1"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        UserRegistration registration = new UserRegistration();
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> registration.registerUser("JohnDoe", "john@example.com", "short"));
        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }
}
