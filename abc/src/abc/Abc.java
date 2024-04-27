package abc;
import java.util.ArrayList;
import java.util.List;
class User {

    private String username;
    private String password;
    private List<BankAccount> accounts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}

// BankAccount class represents a bank account
class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: +" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
            return true;
        }
        return false;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}

// Main class to run the banking system
public class Abc {
    public static void main(String[] args) {
        // Sample usage
        User user = new User("john123", "password");

        // Create bank accounts for the user
        BankAccount account1 = new BankAccount("1234567890");
        BankAccount account2 = new BankAccount("0987654321");
        user.getAccounts().add(account1);
        user.getAccounts().add(account2);

        // Deposit and withdraw from accounts
        account1.deposit(1000);
        account2.deposit(500);
        account1.withdraw(200);

        // Display account balances and transaction history
        for (BankAccount account : user.getAccounts()) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Transaction History:");
            for (String transaction : account.getTransactionHistory()) {
                System.out.println(transaction);
            }
            System.out.println();
        }
    }
}
