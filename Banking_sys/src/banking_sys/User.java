
package banking_sys;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class User {
    String username;
    private String hashedPassword;
    private String email;
    private Connection connection;
    private static final String db_url="jdbc:mysql://localhost:3306/banking_system";
    private static final String db_user="root";
    private static final String db_pass="KomusMySql@1461";
   
    
    public User(){
       Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter username: ");
        this.username = scanner.nextLine();
        
        System.out.print("Enter hashed password: ");
        this.hashedPassword = scanner.nextLine();
        
        System.out.print("Enter email: ");
        this.email = scanner.nextLine();
        
        scanner.close();
        try{
            connection=DriverManager.getConnection(db_url,db_user,db_pass);

            PreparedStatement statement=connection.prepareStatement("insert into users(username, password, email) values(?,?,?)");  
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.setString(3,email);
            int rowInserted=statement.executeUpdate();
            System.out.println(rowInserted>0);
            System.out.println("Your data is stored Successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}

