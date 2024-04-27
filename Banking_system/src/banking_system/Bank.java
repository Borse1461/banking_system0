/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_system;

/**
 *
 * @author aarti
 */
import java.util.HashMap;
import java.util.Map;

/**
 * The Bank class manages bank accounts.
 */
public class Bank {
    private Map<String, Account> accounts; // Map to store account numbers and their corresponding Account objects
    private DatabaseManager dbManager; // Database manager to handle database operations

    /**
     * Constructs a Bank object with the specified database manager.
     * 
     * @param dbManager The database manager
     */
    public Bank(DatabaseManager dbManager) {
        this.dbManager = dbManager;
        this.accounts = dbManager.loadAccounts(); // Load accounts from the database
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }


    /**
     * Creates a new bank account with the given account number.
     * 
     * 
     * @param accountNumber The account number of the new account
     */
    public void createAccount(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) { // Check if account already exists
            Account account = new Account(accountNumber, 0.0); // Create a new account with initial balance 0
            accounts.put(accountNumber, account); // Add account to the map
            dbManager.saveAccount(account); // Save the account to the database
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    /**
     * Deletes the bank account with the given account number.
     * 
     * @param accountNumber The account number of the account to delete
     */
    public void deleteAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) { // Check if account exists
            accounts.remove(accountNumber); // Remove account from the map
            dbManager.deleteAccount(accountNumber); // Delete the account from the database
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account does not exist.");
        }
    }

    /**
     * Gets the bank account with the given account number.
     * 
     * @param accountNumber The account number of the account to retrieve
     * @return The Account object associated with the account number, or null if not found
     */
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber); // Retrieve account from the map
    }
    
    // Additional methods like deposit and withdraw can be added here
}
