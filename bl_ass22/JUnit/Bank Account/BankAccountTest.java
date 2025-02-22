class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        BankAccount account = new BankAccount(200);
        assertTrue(account.withdraw(100));
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawFailureInsufficientFunds() {
        BankAccount account = new BankAccount(50);
        assertFalse(account.withdraw(100));
        assertEquals(50, account.getBalance());
    }
}
