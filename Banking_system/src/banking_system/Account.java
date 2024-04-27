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
/**
 * The Account class represents a bank account.
 */
public class Account {
    private String accountNumber; // The unique account number
    private double balance; // The current balance of the account

    /**
     * Constructs an Account object with the specified account number and balance.
     * 
     * @param accountNumber The account number
     * @param balance       The initial balance of the account
     */
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Gets the account number.
     * 
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of the account.
     * 
     * @return The balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     * 
     * @param balance The new balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    // Additional methods like deposit and withdraw can be added here
}
