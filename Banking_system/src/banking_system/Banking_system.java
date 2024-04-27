/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_system;
import java.util.Scanner;
/**
 *
 * @author aarti
 */
public class Banking_system {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/banking_system";
        String user = "root";
        String password = "KomusMySql@1461";

        // Create a DatabaseManager object to manage database operations
        DatabaseManager dbManager = new DatabaseManager(url, user, password);
        
        // Create a Bank object to manage bank accounts using the DatabaseManager
        Bank bank = new Bank(dbManager);

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        String choice;

        // Main menu loop
        do {
            // Display main menu options
            System.out.println("\n1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextLine();

            // Perform actions based on user choice
            switch (choice) {
                case "1":
                    // Prompt user to enter account number and create account
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    bank.createAccount(accNum);
                    break;
                case "2":
                    // Prompt user to enter account number and delete account
                    System.out.print("Enter account number to delete: ");
                    String accNumDelete = scanner.nextLine();
                    bank.deleteAccount(accNumDelete);
                    break;
                case "3":
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("3")); // Continue loop until user chooses to exit

        // Close Scanner and database connection
        scanner.close();
        dbManager.closeConnection();
    }
}