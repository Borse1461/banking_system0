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
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * The DatabaseManager class manages database operations.
 */
public class DatabaseManager {
    private Connection connection; // Connection object for interacting with the database

   
    private static final String url="jdbc:mysql://localhost:3306/banking_system";
    private static final String user="root";
    private static final String password="KomusMySql@1461";
    
    public DatabaseManager(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password); // Establish connection to the database
            createTable(); // Create the accounts table if it doesn't exist
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the accounts table in the database if it doesn't exist.
     */
    private void createTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = 
                    "CREATE TABLE IF NOT EXISTS accounts (" +
                    "account_number VARCHAR(20) PRIMARY KEY," +
                    "account_holder_name VARCHAR(100) NOT NULL,"+
                    "account_type VARCHAR(100) NOT NULL,"+
                    "balance DOUBLE,"+
                    "credit DOUBLE," +
                    "debit DOUBLE" +
                    ")";
            statement.execute(sql); // Execute the SQL statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads accounts from the database and returns them as a map of account numbers to Account objects.

* 
     * @return A map of account numbers to Account objects
     */
    public Map<String, Account> loadAccounts() {
        Map<String, Account> accounts = new HashMap<>();
        try {
            String sql = "SELECT * FROM accounts"; // SQL query to select all accounts
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql); // Execute the query
            while (resultSet.next()) {
                String accountNumber = resultSet.getString("account_number"); // Get account number from result set
                double balance = resultSet.getDouble("balance"); // Get balance from result set
                accounts.put(accountNumber, new Account(accountNumber, balance)); // Add account to the map
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts; // Return the map of accounts
    }

    /**
     * Saves the specified account to the database.
     * 
     * @param account The account to save
     */
    public void saveAccount(Account account) {
        try {
            String sql = "INSERT INTO accounts (account_number, balance) VALUES (?, ?)"; // SQL query to insert account
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getAccountNumber()); // Set account number parameter
            preparedStatement.setDouble(2, account.getBalance()); // Set balance parameter
            preparedStatement.executeUpdate(); // Execute the update
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the account with the specified account number from the database.
     * 
     * @param accountNumber The account number of the account to delete
     */
    public void deleteAccount(String accountNumber) {
        try {
            String sql = "DELETE FROM accounts WHERE account_number = ?"; // SQL query to delete account
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountNumber); // Set account number parameter
            preparedStatement.executeUpdate(); // Execute the update
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the database connection.
     */
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close(); // Close the connection
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

