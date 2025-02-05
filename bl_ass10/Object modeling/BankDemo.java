import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public Account openAccount(Customer customer, double initialBalance) {
        Account newAccount = new Account(this, customer, initialBalance);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        return newAccount;
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: " + account.getBalance());
        }
    }
}

class Account {
    private Bank bank;
    private Customer customer;
    private double balance;

    public Account(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank("National Bank");
        Bank bank2 = new Bank("City Bank");

        Customer customer1 = new Customer("Sam");
        Customer customer2 = new Customer("Anu");

        bank1.openAccount(customer1, 1000.0);
        bank2.openAccount(customer1, 2000.0);
        bank1.openAccount(customer2, 1500.0);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
