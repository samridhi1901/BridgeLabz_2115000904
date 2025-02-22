class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("StrongPass1"));
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Abc1"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("weakpassword1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValid("NoDigitsHere"));
    }

    @Test
    void testExactEightCharacters() {
        assertTrue(PasswordValidator.isValid("A1bcdefg"));
    }
}
