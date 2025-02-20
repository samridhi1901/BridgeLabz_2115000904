import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber));
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
            System.out.println("Deposited $" + amount + " to Account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for Account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            if (accounts.containsKey(accountNumber)) {
                System.out.println("Processing withdrawal for Account " + accountNumber);
            }
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts Sorted by Balance:");
        sortedAccounts.forEach((balance, account) -> System.out.println("Account " + account + ": $" + balance));
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(101, 1500.0);
        bank.createAccount(102, 2000.0);
        bank.createAccount(103, 1200.0);

        bank.deposit(101, 500.0);
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(103);

        System.out.println();
        bank.displaySortedAccounts();

        System.out.println();
        bank.processWithdrawals();
    }
}
