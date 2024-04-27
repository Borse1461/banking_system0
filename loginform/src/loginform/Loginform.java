package loginform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Loginform {
    public static void main(String[] args) {
        String password = "KomusMySql@1461";
        String username = "root";
        String jdbcUrl = "jdbc:mysql://localhost:3306/abc";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);
            
            try {
                Statement statement = con.createStatement();
                String sql = "create table User(uid int primary key, name varchar(30), address varchar(50))";
                statement.executeUpdate(sql);
                System.out.println("Table creation done successfully");
            } catch (SQLException e) {
                System.out.println("Error executing SQL query: " + e.getMessage());
            } finally {
                // Close the connection in finally block to ensure it always happens
                if (con != null) {
                    con.close();
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}
