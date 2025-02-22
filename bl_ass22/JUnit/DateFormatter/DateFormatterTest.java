class DateFormatterTest {

    @Test
    void testValidDate() {
        assertEquals("25-12-2023", DateFormatter.formatDate("2023-12-25"));
    }

    @Test
    void testAnotherValidDate() {
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertEquals("Invalid Date", DateFormatter.formatDate("12/25/2023"));
    }

    @Test
    void testEmptyDate() {
        assertEquals("Invalid Date", DateFormatter.formatDate(""));
    }

    @Test
    void testNonDateString() {
        assertEquals("Invalid Date", DateFormatter.formatDate("invalid-date"));
    }
